package edu.heu.soft.service.impl;

import edu.heu.soft.domain.Report;
import edu.heu.soft.domain.ReportAuditMapper;
import edu.heu.soft.domain.User;
import edu.heu.soft.domain.UserMapper;
import edu.heu.soft.service.ReportAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by mjrt on 2/26/2017.
 */
@Service
public class ReportAuditServiceImpl implements ReportAuditService {

    public static String AUDITED = "已审核";
    public static String REJECTED = "未通过";

    @Autowired
    ReportAuditMapper reportMapper;
    @Autowired
    UserMapper userMapper;
//    subordinate
    @Override
    public List<Report> query(String name, String state, Date startDate, Date endDate) {
        return reportMapper.findByNameAndStateAndDate(name,state,startDate,endDate);
    }

//    @Override
//    public Map<String,List<Report>> queryBatch(List<String> names, String state, Date startDate, Date endDate){
//        Map<String,List<Report>> res = new HashMap<>();
//
//        for(String name : names){
//            res.put(name,query(name,state,startDate,endDate));
//        }
//        return res;
//    }

    @Override
    public List<Report> queryBatch(List<String> names, String state, Date startDate, Date endDate){
        List<Report> res = new ArrayList<>();

        for(String name : names){
            res.addAll(query(name,state,startDate,endDate));
        }

        return res;
    }

    @Override
    public List<Report> queryBySubordinate(String leaderName,String state, Date startDate, Date endDate){
//        String department = userMapper.findByName(leaderName).getDepartment();
//        List<User> users = userMapper.findByDepartment(department);
//
//        List<String> names = new ArrayList<>();
//        for(User user: users){
//            if(!user.getName().equals(leaderName)){
//                names.add(user.getName());
//            }
//        }
//        return queryBatch(names,state,startDate,endDate);
        String department = userMapper.findByName(leaderName).getDepartment();
        List<User> users = userMapper.findByDepartment(department);

        List<String> names = new ArrayList<>();
        for(User user: users){
            if(!user.getName().equals(leaderName)){
                names.add(user.getName());
            }
        }
        return queryBatch(names,state,startDate,endDate);
    }

    @Override
    public int update(Report report) {
        return reportMapper.save(report);
    }

    @Override
    public List<String> querySubordinate(String leaderName) {
        return reportMapper.findSubordinate(leaderName);
    }

    @Override
    public int audit(List<Integer> id, String state) {
        if(!state.equals(AUDITED) && !state.equals(REJECTED)){
            return 0;
        }

        int result=0;
        for(int i : id){
            result+= reportMapper.audit(i,state);
        }
        return result;

    }
}
