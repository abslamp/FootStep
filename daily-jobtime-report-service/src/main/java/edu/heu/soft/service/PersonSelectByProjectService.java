package edu.heu.soft.service;


import edu.heu.soft.domain.PersonSelectByProject;
import edu.heu.soft.domain.Report;


import java.util.Date;
import java.util.List;
/**
 * Created by new on 17-2-23.
 */
public interface PersonSelectByProjectService {
    /**
     * 查询信息所有的服务层接口
     * @param stratTime 查询开始日期
     * @param endTime 查询截止日期
     * @param name 提交日报人员姓名
     *@param page 页数
     * @return 将返回值项目、总工作量、加班工作量封装为PersonSelectByProject的Pojo类返回
     */
    List<PersonSelectByProject> selectByProject(Date stratTime, Date endTime, String name, int page);
    /**
     * 查询总行数服务层接口
     * @param stratTime  查询开始日期
     * @param endTime 查询截止日期
     * @param name 提交日报人员姓名
     *
     * @return 总行数
     */
    int getCount(Date stratTime, Date endTime, String name);
    /**
     * 得到日报中所有编写人员姓名,提供给下拉菜单的服务层接口
     * @return 所有日报信息
     */
    List<Report> getName();
}
