package edu.heu.soft.service.impl;

import edu.heu.soft.common.DateUtils;
import edu.heu.soft.domain.*;
import edu.heu.soft.service.UnfinishedReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by mjrt on 2/26/2017.
 */
@Service
public class UnfinishedReportServiceImpl implements UnfinishedReportService {

    @Autowired
    ReportMapper reportMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<Date> query(String name) {
        Date now = new Date();
        List<Report> reports = reportMapper.findByNameAndDate(name, DateUtils.getNextOrBeforeDay(now,-14),now);
        List<Date > res =  new ArrayList<>();

        for (Report report : reports){
            res.add(report.getJmt());
        }
        return res;
    }

    @Override
    public Map<String, List<Date>> queryDepartment(String departmentName) {
        List<User> users = userMapper.findByDepartment(departmentName);
        if (users == null)  return null;
        List<String> names = new ArrayList<>();
        for (User user : users){
            names.add(user.getName());
        }
        return queryBatch(names);
    }

    @Override
    public Map<String, List<Date> > queryBatch(List<String> names) {
        Map<String, List<Date> > res = new HashMap<>();
        for(String name : names){
            res.put(name,query(name));
        }
        return res;
    }
}
