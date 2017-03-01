package edu.heu.soft.service;

import edu.heu.soft.domain.DepartmentAllNum;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-27.
 */

public interface DepartmentAllNumService {

    /*
    *
    *  startTime 开始时间
    *  endTime 截止时间
    *  department 部门
    *  List<DepartmentAllNum> Num 返回查询的部门汇总值 作为数据源
    */
    List<DepartmentAllNum> Num(Date startTime, Date endTime, String department);
    /*
    *
    *  Num 数据源
    *  page 分页查询的页数
    *  List<DepartmentAllNum> SelectNum 返回所查询的数据
    */


    List<DepartmentAllNum> SelectNum(DepartmentAllNum num, Integer page);
    /*
    *
    *  startTime 开始时间
    *  endTime 截止时间
    *  department 部门
   */
    int getCount(Date startTime, Date endTime, String department);

}
