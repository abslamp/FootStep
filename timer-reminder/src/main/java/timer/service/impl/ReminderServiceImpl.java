package timer.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timer.common.DateUtils;
import timer.domain.*;
import timer.service.ReminderService;

import java.util.*;

/**
 * Created by mjrt on 2/24/2017.
 */
@Service
@Log4j2
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    ReportMapper reportMapper;
    @Autowired
    ReminderMessageMapper messageMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Report> queryReport(Date jmt,int role) {
        List<Report> reports = reportMapper.findByDateOrderByDate(jmt);

        List<Report> res = new ArrayList<>();
        for (Report report : reports){
            if(userMapper.findByName(report.getName()).getRole() == role ){
                res.add(report);
            }
        }
        return res;
    }

    @Override
    public void setMessage(int role) {

        if (role == 3){
            remindEmployee();
        } else if (role < 3){
            remindLeader();
        }
    }

    @Override
    public List<String> query(String name) {
        List<ReminderMessage>  messages = messageMapper.findByName(name);
        Set<String> res = new HashSet<>();
        for (ReminderMessage message : messages){
            res.add(message.getMessage());
        }
        return new ArrayList<>(res);
    }

    private void remindLeader() {
        List<Report> reports = getReportByState("未审核");
        Set<String> names = new HashSet<>();
        List<String> res = new ArrayList<>();

        for (Report report : reports){
            names.add(report.getName());
        }

        for (String name : names){
            String department = userMapper.findByName(name).getDepartment();
            String leader = departmentMapper.findByName(department).getLeader();
            res.add(leader);
        }

        addMessageByName(res,"您还有日报未审批");
    }

    private void remindEmployee(){
        Date now = new Date();
        String remark = "没有完成日报";
        List<Report> reports = queryReport(now,3);
        List<Date> lacks = null;
        if(!reports.get(0).getName().equals(reports.get(1).getName())){
            if((lacks = getLackDates(reports.get(0).getJmt(),now)) != null){
                addMessageByDates(lacks,reports.get(0).getName(),remark);
            }
        }

        for(int i = 1 ; i < reports.size() ; i++){
            log.error("index"+i+":");
            if(reports.get(i-1).getName().equals(reports.get(i).getName())){
                if((lacks = getLackDates(reports.get(i-1).getJmt(),reports.get(i).getJmt())) != null){
                    addMessageByDates(lacks,reports.get(i-1).getName(),remark);
                }
            } else {
                if((lacks = getLackDates(reports.get(i-1).getJmt(),now)) != null){
                    addMessageByDates(lacks,reports.get(i-1).getName(),remark);
                }
            }
        }
    }

    private List<Report> getReportByState(String state){
        return reportMapper.findByStateOrderByProjectAndName(state);
    }

    private List<Date> getLackDates(Date start , Date end){
        if (start.equals(end))  return null;

        System.out.println(start.getTime() + "--" + DateUtils.getFormatString(start));
        System.out.println(end.getTime() + "--" + DateUtils.getFormatString(end));

        if (start.getTime() > end.getTime()){
            return null;
        }

        if (DateUtils.getWeek(end) == 1){
            end = DateUtils.getNextOrBeforeDay(end,-2);
        }

        end = DateUtils.getNextOrBeforeDay(end,-1);
        if(start.equals(end)){
            return null;
        }

        List<Date> res = new ArrayList<>();

        int tot = 0;
        while(!start.equals(end) && tot < 14 ){
            tot++;
            System.out.println("start:"+DateUtils.getFormatString(start) +"***"+"end:"+DateUtils.getFormatString(end));

            int week = DateUtils.getWeek(end);
            if(week !=6 && week != 0){
                res.add(end);
            }
            end = DateUtils.getNextOrBeforeDay(end,-1);
            if (start.getTime() > end.getTime()){
                return null;
            }
        }

        return res;
    }

    private void addMessageByDates(List<Date> dates,String name,String remark){
        for (Date lack : dates){
            ReminderMessage message = new ReminderMessage();
            message.setUserName(name);
            message.setLack(lack);
            message.setMessage(message.getUserName()+":"+DateUtils.getFormatString(lack)+remark);
            message.setState(false);
            if(messageMapper.findByPojo(message) == null){
                messageMapper.insert(message);
            }

        }
    }

    private void addMessageByName(List<String> names,String remark){

        Date now = new Date();
        for (String name : names){
            ReminderMessage message = new ReminderMessage();
            message.setUserName(name);
            message.setLack(now);
            message.setMessage(message.getUserName()+":"+DateUtils.getFormatString(now)+remark);
            message.setState(false);
            if(messageMapper.findByPojo(message) == null){
                messageMapper.insert(message);
            }

        }

    }
}
