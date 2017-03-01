package edu.heu.soft.service.impl;

import edu.heu.soft.domain.*;
import edu.heu.soft.service.WorkLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/26/2017.
 */
@Service
public class WorkLoadServiceImpl implements WorkLoadService {

    @Autowired
    ProjectAndDepartmentMapper projectAndDepartmentMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ReportMapper reportMapper;

    @Override
    public List<ProjectWorkLoad> queryByProject(String department, Date startDate, Date endDate) {
        List<String> projectsName = projectAndDepartmentMapper.findProjectByDepartment(department);
        List<String> projects = new ArrayList<>();

        for(String name : projectsName){
            Project project = projectMapper.findByName(name);

            if(startDate.getTime() <= project.getStartTime().getTime() && project.getEndTime().getTime() <= endDate.getTime()){
                projects.add(project.getName());
            }

        }

        List<ProjectWorkLoad> workLoads = new ArrayList<>();
        for (String project : projects){
            double totalOverTime = 0.0;
            double totalWorkLoad = 0.0;
            List<Report> reports = reportMapper.findByProject(project);
            for (Report report : reports){
                totalOverTime += report.getOverTime();
                totalWorkLoad += report.getWorkLoad();
            }
            totalWorkLoad += totalOverTime;

            workLoads.add(new ProjectWorkLoad(project,totalWorkLoad,totalOverTime));
        }
        return workLoads;
    }

}
