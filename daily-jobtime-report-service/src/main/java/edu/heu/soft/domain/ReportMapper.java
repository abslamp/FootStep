package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-21.
 */

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

public interface ReportMapper {
//   Report findReportCond(Date start, Date end, String project, String prp, String task, String state);
   List<Report> findReport(@Param("start") Date start, @Param("end") Date end, @Param("cond") Report cond, @Param("offset") int offset, @Param("total") int total);
   int getCount(@Param("start") Date start, @Param("end") Date end, @Param("cond") Report cond);
   List<Report> findReportProject();
   List<Report> findReportPrp();
   int insert(@Param("jmt") Date jmt, @Param("name") String name, @Param("project") String project, @Param("task") String task, @Param("prp") String prp, @Param("workLoad") double workLoad, @Param("overTime") double overTime);
   void delete(@Param("id") Long id);
   void update(@Param("id") Long id, @Param("jmt") Date jmt, @Param("project") String project, @Param("task") String task, @Param("prp") String prp, @Param("workLoad") double workLoad, @Param("overTime") double overTime);
   Report findById(Long id);
   List<ProjectAndPrp>findPapPrp();
   List<ProjectAndUser>findPauProject();

   List<Report> findByNameAndDate(@Param("name") String name, @Param("startDate")Date startDate, @Param("endDate")Date endDate);

   List<Report> findByProject(@Param("project")String project);
}