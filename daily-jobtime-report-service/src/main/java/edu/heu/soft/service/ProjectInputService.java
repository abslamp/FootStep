package edu.heu.soft.service;

import edu.heu.soft.domain.Report;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-27.
 */
public interface ProjectInputService {


      /*
    * 按分页查询查询所有数据
    *
    * @param project
    * @param start
    * @param  end
    * @param page
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
    int getCount(String project, Date start, Date end);
    List<Report>findProjectInput(String project, Date start, Date end, int page);
    List<Report> queryReportProject();
}
