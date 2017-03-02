package edu.heu.soft.controller;

import edu.heu.soft.service.UnfinishedReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mjrt on 2/26/2017.
 */
@RestController
@RequestMapping("/unfinished")
public class UnfinishedReportController {
    @Autowired
    UnfinishedReportService service;

    @GetMapping("/user")
    List<Date> queryByUser(String name){
        return service.query(name);
    }

    @GetMapping("/department")
    Map<String,List<Date>> querybyDepartment(String leaderName){
        return service.queryDepartment(leaderName);
    }

}
