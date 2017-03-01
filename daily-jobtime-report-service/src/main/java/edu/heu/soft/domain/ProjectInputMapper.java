package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-27.
 */
public interface ProjectInputMapper {


    /*
    * 按分页查询查询所有数据
    *
    * @param project
    * @param start
    * @param  end
    * @param offset 分页查询的定位点
    * @param total
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

    List<Report>findInput(@Param("project") String project, @Param("start") Date start, @Param("end") Date end, @Param("offset") int offset, @Param("total") int total);


    int getCount(@Param("start") Date start, @Param("end") Date end, @Param("project") String project);
    List<Report> findReportProject();

}
