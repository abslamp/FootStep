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

    boolean testTap = false;
    boolean leaderTap = false;
    boolean employeeTap = false;

    @GetMapping
    List<Report> query(Date jmt,int role){
        return service.queryReport(jmt,role);
    }

    @GetMapping("/reminder")
    void reminder(int role){
        service.setMessage(role);
    }

    @GetMapping("/test")
    void setTestTap(boolean tap){
        testTap = tap;
        log.info( (testTap?"turn on":"turn off")+" :TestTap");
    }

    @Scheduled(fixedRate = 3000)
    void printNowTime(){
        if(testTap){
            System.out.println(DateUtils.getFormatString(new Date()));
        }
    }

}