package edu.heu.soft.service.impl;

import edu.heu.soft.domain.ProjectInputMapper;
import edu.heu.soft.domain.Report;
import edu.heu.soft.service.ProjectInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-27.
 */
@Service
public class ProjectInputServiceImpl implements ProjectInputService {

    @Autowired
    ProjectInputMapper mapper;
    static  int pageSize=5;
    @Override
    public int getCount(String project, Date start, Date end) {
         return mapper.getCount(start,end,project);
    }

    @Override
    public List<Report> findProjectInput(String project, Date start, Date end,int page) {
        int offset=(page-1)*pageSize;
        return mapper.findInput(project,start,end,offset,pageSize);
    }
    @Override
    public List<Report> queryReportProject() {
        return mapper.findReportProject();
    }
}
