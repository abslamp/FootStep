package edu.heu.soft.controller;

import edu.heu.soft.common.CookieUtils;
import edu.heu.soft.domain.Report;
import edu.heu.soft.service.ReportAuditService;
import edu.heu.soft.service.impl.ReportAuditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by mjrt on 2/26/2017.
 * Modified by lzma on 2/27/2017. - Added fake pagination & subordinate methods
 */
@RestController
@RequestMapping("/audit")
public class ReportAuditController {
    @Autowired
    ReportAuditService service;

//    Map<String,List<Report>> query(HttpServletRequest request , String name , String state , Date startDate,Date endDate){
//
//        if (name == null){
//            String leaderName = CookieUtils.findCookieByName("userName",request).getValue();
//            return service.queryBySubordinate(leaderName,state,startDate,endDate);
//        }
//
//        Map<String,List<Report>> res = new HashMap<>();
//        res.put(name,service.query(name,state,startDate,endDate));
//        return res;
//    }
    @RequestMapping(value = "/query")
    List<Report> query(HttpServletRequest request , String name , String state , Date startDate,Date endDate,Integer page){
        List<Report> result;

        if (name == null || name.equals("")){
            String leaderName = null;
            try {
                leaderName = CookieUtils.findCookieByName("username",request).getValue();
            } catch (Exception e) {
                return null;
            }
            try {
                leaderName = java.net.URLDecoder.decode(leaderName,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();

            }
            result = service.queryBySubordinate(leaderName,state,startDate,endDate);
        } else {
            result = service.query(name,state,startDate,endDate);
        }

        if(page==null || page==0) {
            return result;
        }
        try {
            return result.subList((page-1)*5, (page*5) >=(result.size()) ? result.size() : page*5);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @RequestMapping(value = "/getcount")
//    int getCount(HttpServletRequest request,String name , String state , Date startDate,Date endDate) {
//
//        if (name == null){
//            String leaderName = null;
//            try {
//                leaderName = CookieUtils.findCookieByName("username",request).getValue();
//            } catch (Exception e) {
//                //e.printStackTrace();
//                return 0;
//            }
//            try {
//                leaderName = java.net.URLDecoder.decode(leaderName,"UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//
//            }
//            return service.queryBySubordinate(leaderName,state,startDate,endDate).size();
//        }
//        System.out.println(endDate);
//        return service.query(name,state,startDate,endDate).size();
//    }

    @RequestMapping(value = "/getcount")
    int getCount(HttpServletRequest request,String name , String state , Date startDate,Date endDate) {
        List<Report> result;

        if (name == null || name.equals("")){
            String leaderName = null;
            try {
                leaderName = CookieUtils.findCookieByName("username",request).getValue();
            } catch (Exception e) {
                return 1;
            }
            try {
                leaderName = java.net.URLDecoder.decode(leaderName,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();

            }
            result = service.queryBySubordinate(leaderName,state,startDate,endDate);
        } else {
            result = service.query(name,state,startDate,endDate);
        }

        try {
            return result.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    @RequestMapping(value = "/subordinate")
    List<String> getSubordinate(HttpServletRequest request,String name) {
        if (name == null || name.equals("")) {
            String leaderName = null;
            String role;
            try {
                leaderName = CookieUtils.findCookieByName("username",request).getValue();
                role = CookieUtils.findCookieByName("role",request).getValue();
            } catch (Exception e) {
                return null;
            }
            try {
                leaderName = java.net.URLDecoder.decode(leaderName,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            int roleNum=0;
            try {
                roleNum = Integer.parseInt(role);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            System.out.println(leaderName);

            if(roleNum == 1) return service.queryEveryone();
            else if(roleNum == 2) return service.querySubordinate(leaderName);
            else return new ArrayList<>();
        } else {
            return service.querySubordinate(name);
        }
    }

    @RequestMapping(value = "/update")
    int update(Report report){
        return service.update(report);
    }

    @RequestMapping(value = "/accept")
    int accept(Integer[] id) {
        //System.out.println(id);
        if (id != null && id.length>0){
            List<Integer> idList = new ArrayList<>(Arrays.asList(id));
            System.out.println(idList);
            return service.audit(idList, ReportAuditServiceImpl.AUDITED);
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/reject")
    int reject(Integer[] id) {
        if (id != null && id.length>0){
            List<Integer> idList = new ArrayList<>(Arrays.asList(id));
            System.out.println(idList);
            return service.audit(idList, ReportAuditServiceImpl.REJECTED);
        } else {
            return 0;
        }
    }

}
