package edu.heu.soft.service;


import edu.heu.soft.domain.ProjectAndPrp;
import edu.heu.soft.domain.ProjectAndUser;
import edu.heu.soft.domain.Report;
import edu.heu.soft.domain.SelectReport;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-21.
 */
public interface ReportService {

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
    * @param page
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

    List<Report> query(Date start, Date end, Report cond, int page);
    int getCount(Date start, Date end, Report cond);
    //Report queryAll( Date start,Date end,String project, String prp ,String task, String state);
    List<Report> queryReportProject();
    List<Report> queryReportPrp();
    void delete(Long id);
    List<ProjectAndPrp>findPapPrp();
    List<ProjectAndUser>findPauProject();
    String insert(Report report);
    void update(Long id, Date jmt, String project, String task, String prp, double workLoad, double overTime);
    Report findById(Long id);

}
