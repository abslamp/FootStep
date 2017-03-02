package edu.heu.soft.service.impl;

import edu.heu.soft.domain.DepartmentAllNum;
import edu.heu.soft.domain.DepartmentAllNumMapper;
import edu.heu.soft.service.DepartmentAllNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-27.
 */
@Service
public class DepartmentAllNumServiceImpl implements DepartmentAllNumService{

    @Autowired
    private DepartmentAllNumMapper mapper;

    static int pageSize=5;

     /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
    * return Num 返回按照日期和部门查询到的人员和其工作量汇总
    *
    */


    @Override
    public List<DepartmentAllNum>Num(Date startTime,Date endTime,String department){

        return mapper.Num(startTime,endTime,department);
    }



    /*
    *
    * @param Num 数据源
    * @param page 分页查询的页数
    * @param pageSize 一页显示多少行
    * @param offset 计算分页的定位点
    * @param SelectNum 返回所需要的分页查询结果
    */


    @Override
    public List<DepartmentAllNum>SelectNum (DepartmentAllNum Num,Integer page)
    {
        int offset = (page-1)*pageSize;
        return mapper.SelectNum(Num,offset,pageSize);

    }


    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
     */
    @Override
    public int getCount(Date startTime,Date endTime,String department){

        return  mapper.getCount(startTime,endTime,department);
    }
}
