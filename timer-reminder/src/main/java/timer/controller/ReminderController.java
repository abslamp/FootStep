package timer.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timer.common.DateUtils;
import timer.domain.Report;
import timer.service.ReminderService;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/24/2017.
 */
@RestController
@RequestMapping(value = "/reminder")
@Log4j2
public class ReminderController {

    @Autowired
    ReminderService service;

    boolean testTap = true;
    boolean leaderTap = true;
    boolean employeeTap = true;


    @GetMapping
    List<String> reminder(String name){
        return service.query(name);
    }


    @GetMapping("/employeeTap")
    void setEmployeeTap(boolean tap){
        employeeTap = tap;
        log.info( (employeeTap?"turn on":"turn off")+" :employeeTap");
    }

    @GetMapping("/leaderTap")
    void setLeaderTapTap(boolean tap){
        leaderTap = tap;
        log.info( (employeeTap?"turn on":"turn off")+" :employeeTap");
    }

    @Scheduled(fixedRate = 5000)
    void employeedMessage(){
        if(employeeTap){
            service.setMessage(3);
        }
    }

    @Scheduled(fixedRate = 50000)
    void leaderMessage(){
        if(leaderTap){
            service.setMessage(2);
        }
    }
}