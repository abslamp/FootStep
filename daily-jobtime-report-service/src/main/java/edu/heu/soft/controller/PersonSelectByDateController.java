package edu.heu.soft.controller;

import edu.heu.soft.domain.PersonSelectByDate;
import edu.heu.soft.service.PersonSelectByDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-22.
 */

@RestController
@RequestMapping("/PersonSelectByDate")
public class PersonSelectByDateController {


    @Autowired
    PersonSelectByDateService service;

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param name 名字
    * @return List<PersonSelectByDate> queryByDate 返回的值是个人日报查询（按时间） 作为数据源
    */




    @RequestMapping(value = "/select")
    public List<PersonSelectByDate> queryByDate(Date startTime,Date endTime, String name){
//        System.out.println(startTime.toString());
//        System.out.println(endTime.toString());
//        System.out.println(name);

        List<PersonSelectByDate> datas = service.QueryByDate(startTime,endTime,name);

        return datas;
    }

    /*
    *
    * @param Num 数据源
    * @param page 分页查询的页数
    * @return List<PersonSelectByDate> selectByDate 返回所查询的数据
    */



    @RequestMapping(value = "/work")
    public List<PersonSelectByDate> selectByDate( PersonSelectByDate PersonSelect,Integer page){


        return service.SelectByDate(PersonSelect,page);


    }

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param name 名字
    * @return 返回查询后的行数，用于分页查询
     */

    @RequestMapping(value = "/rows")

        public int getCount(Date startTime,Date endTime,String name)
    {
        //return service.getCount(startTime,endTime,name);
        return service.QueryByDate(startTime,endTime,name).size();
    }








}
