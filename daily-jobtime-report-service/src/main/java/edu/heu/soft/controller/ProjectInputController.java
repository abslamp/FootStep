package edu.heu.soft.controller;

import edu.heu.soft.domain.Report;
import edu.heu.soft.service.ProjectInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-27.
 */

@RestController
@RequestMapping("/SelectProjectInput")

public class ProjectInputController {


      /*
    * 按分页查询查询所有数据
    *
    * @param project
    * @param start
    * @param  page
    * @return Report
     */

    /*
    * 分页查询时查询出返回值数量
    *
    * @param project
    * @param start
    * @param  end
    * @param offset 分页查询的定位点
    * @param total
    * @return Report
     */

    /*
    * 下拉菜单的动态查询
    *
    *
    * @return Report
     */
    @Autowired
    ProjectInputService service;
    @RequestMapping(value = "/ProjectInput" )
    public List<Report> queryProject( String project,Date start, Date end,Integer page){
        if(page==null) page=1;

        return service.findProjectInput(project,start,end,page);
    }
    @RequestMapping(value = "/rowscount" )
    public int  rowsCount (Date start,Date end,String project){
        return service.getCount(project,start,end);
    }
    @RequestMapping(value = "/project")
    public List<Report> queryReportProject(){

        return service.queryReportProject();
    }

}
