package edu.heu.soft.service;

import edu.heu.soft.domain.DepartmentUnauditedSelect;
import edu.heu.soft.domain.PersonSelectByDate;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-26.
 */
public interface DepartmentUnauditedSelectService {

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
    * @return List<DepartmentUnauditedSelect> QueryByDate 返回未审核部门值 作为数据源
    */
    List<DepartmentUnauditedSelect> QueryByDate(Date startTime, Date endTime, String department, int page);

    /*
    *
    * @param DepartmentSelect 数据源
    * @param page 分页查询的页数
    * @return List<DepartmentUnauditedSelect> SelectByDate 返回所查询的数据
    */

    List<DepartmentUnauditedSelect> SelectByDate(DepartmentUnauditedSelect DepartmentSelect, Integer page);

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
     */
    int getCount(Date startTime, Date endTime, String department);
}
