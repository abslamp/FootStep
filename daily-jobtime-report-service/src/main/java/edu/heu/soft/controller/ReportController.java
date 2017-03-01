package edu.heu.soft.controller;

import edu.heu.soft.domain.ProjectAndPrp;
import edu.heu.soft.domain.ProjectAndUser;
import edu.heu.soft.domain.Report;
import edu.heu.soft.domain.SelectReport;
import edu.heu.soft.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-22.
 */

@RestController
@RequestMapping("/SelectReport")

public class ReportController {

    /*
    * 按分页查询查询所有数据
    *
    * @param cond
    * @param start
    * @param  end
    * @param offset 分页查询的定位点
    * @param total
    * @return Report
     */

    /*
    * 分页查询时查询出返回值数量
    *
    * @param cond
    * @param start
    * @param  end
    * @param offset 分页查询的定位点
    * @param total
    * @return Report
     */

    /*
    * project下拉菜单的动态查询
    *
    *
    * @return Report
     */


     /*
    * prp下拉菜单的动态查询
    *
    *
    * @return Report
     */

     /*
    * 插入语句方法
    *
    * @param Date jmt@,,
    * @Param String name
    * @Param String project
    * @Param String task
    * @Param String prp,
    * @Param double workLoad,
    * @Paramdouble overTime
    * @return Report
     */

     /*
    * 修改语句方法
    *
    * @param String name
    * @Param Date jmt 日期
    * @Param String project,
    * @Param String prp
    * @Param String task,
    * @Param double workLoad,
    * @Paramdouble overTime
    * @return Report
     */

    /*
  * 通过ID删除语句方法
  *
  * @param id
  * @return Report
   */


    @Autowired
    ReportService service;
  /*  @RequestMapping(value = "/cond" , method = RequestMethod.GET)
    public Report queryAll(Date start,Date end, String project, String prp , String task, String state){

        return service.queryAll(start,end,project,prp,task,state);
    }*/
    @RequestMapping(value = "/all" )
    public List<Report> query(Date start, Date end, Report cond , int page){

        return service.query(start,end,cond, page);
    }
    @RequestMapping(value = "/rowscount" )
    public int  rowsCount (Date start,Date end,Report cond){
        return service.getCount(start, end,cond);
    }

    @RequestMapping(value = "/project")
    public List<Report> queryReportProject(){

        return service.queryReportProject();
    }


    @RequestMapping(value = "/prp")
    public List<Report> queryReportPrp(){

        return service.queryReportPrp();
    }
    @RequestMapping(value = "/delete")
    public void delecte(long id)
    {
        service.delete(id);
    }

    @RequestMapping(value = "/Pauproject")
    public List<ProjectAndUser> queryPauProject(){

        return service.findPauProject();
    }
    @RequestMapping(value = "/insert" )
    public String upload(Report report){
        System.out.println(report.toString());
        return service.insert( report);
    }
    @RequestMapping(value = "/update" )
    public void update(Long id ,Date jmt,  String project,  String task,  String prp,  double workLoad, double overTime){

         service.update(id,jmt, project, task, prp, workLoad, overTime);
    }


    @RequestMapping(value = "/Papprp")
    public List<ProjectAndPrp> queryPapPrp(){

        List<ProjectAndPrp>  res = service.findPapPrp();
       // System.out.println(res);
        return res;
    }
    @RequestMapping(value = "/name" )
    public Report findById(Long id){

        return service.findById(id);
    }
}
