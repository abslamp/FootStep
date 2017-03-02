package edu.heu.soft.controller;

import edu.heu.soft.domain.DepartmentAllNum;
import edu.heu.soft.service.DepartmentAllNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-27.
 */
@RestController
@RequestMapping("/DepartmentAllNum")
public class DepartmentAllNumController {

    @Autowired
    DepartmentAllNumService service;

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
    * @return List<DepartmentAllNum> Num 返回查询的部门汇总值 作为数据源
    */







    @RequestMapping(value = "/num")
    public List<DepartmentAllNum> Num (Date startTime,Date endTime,String department){

        return service.Num(startTime,endTime,department);
    }

    /*
    *
    * @param Num 数据源
    * @param page 分页查询的页数
    * @return List<DepartmentAllNum> SelectNum 返回所查询的数据
    */



    @RequestMapping(value = "/work")
    public List<DepartmentAllNum> SelectNum (DepartmentAllNum Num,Integer page)
    {
        return service.SelectNum(Num,page);
    }

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
    * return 返回行数 用于分页查询
     */

    @RequestMapping(value = "/rows")
    public int getCount(Date startTime,Date endTime,String department)
    {
       // return service.getCount(startTime,endTime,department);
        return service.Num(startTime,endTime,department).size();
    }



}
