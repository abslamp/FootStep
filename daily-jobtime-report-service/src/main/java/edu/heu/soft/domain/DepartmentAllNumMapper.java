package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-27.
 */
@Service
public interface DepartmentAllNumMapper {

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
    */

    List<DepartmentAllNum> Num(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("department") String department);

    /*
    *
    * @param Num 数据源
    * @param offset 分页页数
    * @param total 总计
    */


    List<DepartmentAllNum> SelectNum(@Param("Num") DepartmentAllNum Num, @Param("offset") int offset, @Param("total") int total);

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
     */

    int getCount(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("department") String department);



}
