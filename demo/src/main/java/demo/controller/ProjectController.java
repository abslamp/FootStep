package demo.controller;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import demo.domain.*;
import demo.service.ProjectService;
import demo.service.PrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LZMA on 2017/2/19.
 */

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value="/id" ,method= RequestMethod.GET)
    public Project queryById(Long id) {
        return projectService.queryById(id);
    }

    @RequestMapping(value="/all")
    public List<Project> queryAll(Project cond, int page) {
        return projectService.query(cond,page);
    }

    @RequestMapping(value="/rowscount")
    public int rowsCount(Project cond) {
        return projectService.getCount(cond);
    }

    @RequestMapping(value = "/getDepartment")
    public ProjectAndDepartment getDepartment(String name) {
        ProjectAndDepartment result;
        try {
            result = projectService.queryDepartmentLink(name).get(0);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("ProjectController:getDepartment():Index out of bound. Missing link in ProjectAndDepartment table. Consider typo error of Project.name or missing data in db.");
            result = null;
        }
        return result; //假定一对一
    }

    @RequestMapping(value = "/getUser")
    public List<String> getUser(String name) {
        return projectService.queryUserStringLink(name);
    }

    @RequestMapping(value = "/getPrp")
    public List<String> getPrp(String name) {
        // 考虑到可能的数据格式转换将转换过程置于Controller,下同
        List<ProjectAndPrp> raw = projectService.queryPrpLink(name);
        List<String> result = new ArrayList<>();
        for(ProjectAndPrp prp : raw) {
            result.add(prp.getPrpName());
        }
        return result;
        //return projectService.queryPrpLink(name);
    }

    @RequestMapping(value = "/getAllPrp")
    public List<String> getAllPrp() {
        List<Prp> prps = projectService.queryAllPrp();
        List<String> result = new ArrayList<>();
        for(Prp prp : prps){
            result.add(prp.getName());
        }

        return result;
    }

    @RequestMapping(value = "/getUserByDept")
    public List<String> getUserByDepartment(String name) {
        return projectService.queryDepartmentUserString(name);
    }

    @RequestMapping(value = "/insert")
    public int insert(Project project) {
        return projectService.insert(project);
    }

//    @RequestMapping(value = "/set")
//    public i
    @RequestMapping(value = "/setDepartment")
    public int setDepartment(String projectName,String department) {
        return projectService.updateDepartmentLink(projectName,department);
    }

    @RequestMapping(value = "/setUser")
    public int setUser(String projectName,String[] userNames) {
        return projectService.updateUserLink(projectName,userNames);
    }

    @RequestMapping(value = "/setPrp")
    public int setPrp(String projectName,String[] prpNames) {
        return projectService.updatePrpLink(projectName,prpNames);
    }

    @RequestMapping(value="/delete")
    public int delete(int id) {
        System.out.println("Wanna delete "+id);
        return 0;
    }

}
