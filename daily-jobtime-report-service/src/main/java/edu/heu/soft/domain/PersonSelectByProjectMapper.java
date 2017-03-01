package edu.heu.soft.domain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-23.
 */
@Repository
public interface PersonSelectByProjectMapper {
    /**
     * 查询所有信息的映射
     * * @param stratTime 查询开始日期
     * @param endTime 查询截止日期
     * @param name 提交日报人员姓名
     *@param offset 当前位置
     * @param total 页面所显示的行数
     * @return 将返回值项目、总工作量、加班工作量封装为PersonSelectByProject的Pojo类返回
     */
    List<PersonSelectByProject>  selectByProject(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("name") String name, @Param("offset") int offset, @Param("total") int total);
    /**
     * 查询总行映射层
     * @param startTime 查询开始日期
     * @param endTime 查询截止日期
     * @param name 提交日报人员姓名
     *
     * @return 总行数
     */
    int getCount(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("name") String name);
    /**
     * 得到日报中所有编写人员姓名,提供给下拉菜单的映射层
     * @return 所有日报信息
     */


    List<Report> getName();
}
