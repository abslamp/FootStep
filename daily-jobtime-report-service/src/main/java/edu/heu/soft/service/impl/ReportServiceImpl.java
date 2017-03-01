package edu.heu.soft.service.impl;

import edu.heu.soft.domain.*;

import edu.heu.soft.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-21.
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportMapper mapper;
    static  int pageSize=5;

    @Override
    public List<Report> query(Date start, Date end, Report cond, int page) {

        int offset=(page-1)*pageSize;
        return mapper.findReport(start,end,cond,offset,pageSize);
    }




    @Override
    public int getCount(Date start, Date end, Report cond) {
        return mapper.getCount(null,null,cond);
    }

   /* @Override
    public Report queryAll(Date start,Date end, String project, String prp , String task, String state) {
        Report report= mapper.findReportCond(start,end,project,prp,task,state);
        return mapper.findReportCond( start,end,project, prp,task, state );
    }*/

    @Override
    public List<Report> queryReportProject() {
        return mapper.findReportProject();
    }

    @Override
    public List<Report> queryReportPrp() {
        return mapper.findReportPrp();
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }

    @Override
    public List<ProjectAndPrp> findPapPrp() {
        return mapper.findPapPrp();
    }

    @Override
    public List<ProjectAndUser> findPauProject() {
        return mapper.findPauProject();
    }

    @Override
    public String insert(Report report) {

        mapper.insert(report.getJmt(),report.getName(),report.getTask(),report.getPrp(),report.getProject(),report.getWorkLoad(),report.getOverTime());

        return "sucess";

    }

    @Override
    public void update( Long id,Date jmt, String project, String task, String prp, double workLoad, double overTime) {
        mapper.update( id ,jmt,project,task,prp,workLoad,overTime);
    }

    @Override
    public Report findById(Long id) {
        return mapper.findById(id);
    }


}

