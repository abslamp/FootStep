package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-26.
 */
@Service
public interface DepartmentUnauditedSelectMapper {

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
    */

    List<DepartmentUnauditedSelect> QueryByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("department") String department, @Param("offset") int offset, @Param("total") int total);

    /*
    *
    * @param SelectByDate 数据源
    * @param offset 分页页数
    * @param total 总计
    */

    List<DepartmentUnauditedSelect> SelectByDate(@Param("DepartmentSelect") DepartmentUnauditedSelect PersonSelect, @Param("offset") int offset, @Param("total") int total);
    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
    */

    int getCount(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("department") String department);

}
