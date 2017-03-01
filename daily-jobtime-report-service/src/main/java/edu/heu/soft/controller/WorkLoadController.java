package edu.heu.soft.controller;

import edu.heu.soft.domain.ProjectWorkLoad;
import edu.heu.soft.service.WorkLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/26/2017.
 */
@RestController
@RequestMapping("/workload")
public class WorkLoadController {

    @Autowired
    WorkLoadService service;

    @GetMapping
    List<ProjectWorkLoad> queryByProject(String department , Date startDate , Date endDate){
        return service.queryByProject(department,startDate,endDate);
    }


}
