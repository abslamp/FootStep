package edu.heu.soft.controller;

/**
 * Created by new on 17-2-23.
 */




        import edu.heu.soft.domain.PersonSelectByProject;

        import edu.heu.soft.domain.Report;
        import edu.heu.soft.service.PersonSelectByProjectService;
        import org.springframework.beans.factory.annotation.Autowired;

        import org.springframework.web.bind.annotation.RequestMapping;

        import org.springframework.web.bind.annotation.RestController;


        import java.util.Date;
        import java.util.List;

/**
 * Created by new on 17-2-22.
 */

@RestController
@RequestMapping("/PersonSelect")
public class PersonSelectByProjectController {


    @Autowired
    PersonSelectByProjectService service;

    /**
     * 个人查询日报--按项目显示工作量：查询所需信息
     * @param startTime 查询开始日期
     * @param endTime 查询截止日期
     * @param name 提交日报人员姓名
     *@param page 页数
     * @return 将返回值项目、总工作量、加班工作量封装为PersonSelectByProject的Pojo类返回
     */

    @RequestMapping(value = "/ByProject")
    public List<PersonSelectByProject> selectByProject( Date startTime,Date endTime, String name,Integer page){
      if( page == null)
          page=0;
        service.selectByProject(startTime,endTime,name,page);
        return service.selectByProject(startTime,endTime,name,page);

    }
    /**
     * 个人查询日报--按项目显示工作量：查询总行数
     * @param startTime 查询开始日期
     * @param endTime 查询截止日期
     * @param name 提交日报人员姓名
     *
     * @return 总行数
     */
    @RequestMapping(value = "/rowscount")
    public int rowsCount(Date startTime,Date endTime, String name) {
        return service.getCount(startTime,endTime,name);

    }
    /**
     * 个人查询日报--按项目显示工作量：得到日报中所有编写人员姓名
     * @return 所有日报信息
     */
    @RequestMapping(value = "/name")
    public List<Report> getName(){

        return service.getName();
    }
}
