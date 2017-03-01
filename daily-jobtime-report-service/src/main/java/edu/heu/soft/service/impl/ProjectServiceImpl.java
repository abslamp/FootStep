package edu.heu.soft.service.impl;

import edu.heu.soft.domain.*;
import edu.heu.soft.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LZMA on 2017/2/19.
 */

@Service
public class ProjectServiceImpl implements ProjectService {
    private static int pageSize=5;
    //int offset = (page-1)*pageSize;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> query(Project cond, int page) {
        int offset = (page-1)*pageSize;
        return projectMapper.find(cond,offset,pageSize);
    }

    @Override
    public Project queryById(Long id) {
        return projectMapper.findById(id);
    }

    @Override
    public int getCount(Project cond) {
        return projectMapper.getCount(cond);
    }

    @Override
    public List<ProjectAndDepartment> queryDepartmentLink(String projectName) {
        return projectMapper.findDepartmentByProjectName(projectName);
    }

    @Override
    public List<ProjectAndUser> queryUserLink(String projectName) {
        return projectMapper.findUserByProjectName(projectName);
    }

    @Override
    public List<String> queryUserStringLink(String projectName) {
        return projectMapper.findUserStringByProjectName(projectName);
    }

    @Override
    public List<String> queryDepartmentUserString(String projectName) {
        String deptName;
        try {
            deptName = projectMapper.findDepartmentByProjectName(projectName).get(0).getDepartment();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("ProjectServiceImpl:queryDepartmentUserString():Index out of bound. Missing link in ProjectAndDepartment table. Consider typo error of Project.name or missing data in db.");
            return null;
        }
        return projectMapper.findUserStringByDept(deptName);
    }

    @Override
    public List<ProjectAndPrp> queryPrpLink(String projectName) {
        return projectMapper.findPrpByProjectName(projectName);
    }

    @Override
    public List<Prp> queryAllPrp() {
        return projectMapper.findAllPrp();
    }

    @Override
    public int update(Long id, Project replace) {
        return projectMapper.update(id, replace);
    }

    @Override
    public int updateDepartmentLink(String projectName, String departmentName) {
        projectMapper.deleteUserLink(projectName); // 部门易主，组员焉在？
        int delete = projectMapper.deleteDepartmentLink(projectName);
        ProjectAndDepartment target = new ProjectAndDepartment();
        target.setProject(projectName);
        target.setDepartment(departmentName);
        int insert = projectMapper.insertDepartmentLink(target);
        return delete*insert;
    }

    @Override
    public int updateUserLink(String projectName, String[] userNames) {
        int delete = projectMapper.deleteUserLink(projectName);
        int insert = 0;
        ProjectAndUser target = new ProjectAndUser();
        target.setProject(projectName);
        for(String name : userNames) {
            target.setUserName(name);
            insert += projectMapper.insertUserLink(target);
        }
        return delete*insert;
    }

    @Override
    public int updatePrpLink(String projectName, String[] prpNames) {
        int delete = projectMapper.deletePrpLink(projectName);
        int insert = 0;
        ProjectAndPrp target = new ProjectAndPrp();
        target.setProject(projectName);
        for(String name : prpNames) {
            target.setPrpName(name);
            insert += projectMapper.insertPrpLink(target);
        }
        return delete*insert;
    }

    @Override
    public int insert(Project target) {
        return projectMapper.insert(target);
    }
}
