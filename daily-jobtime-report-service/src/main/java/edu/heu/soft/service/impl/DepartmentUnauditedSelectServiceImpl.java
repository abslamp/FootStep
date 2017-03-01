package edu.heu.soft.service.impl;

import edu.heu.soft.domain.DepartmentUnauditedSelect;
import edu.heu.soft.domain.DepartmentUnauditedSelectMapper;
import edu.heu.soft.service.DepartmentUnauditedSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-26.
 */

@Service
public class DepartmentUnauditedSelectServiceImpl implements DepartmentUnauditedSelectService{
    @Autowired
    private DepartmentUnauditedSelectMapper Mapper;

    static int pageSize =5;



        /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
    * return QueryByDate 返回部门未审核查询值
    *
    */

    /*
    *
    * @param DepartmentSelect 数据源
    * @param page 分页查询的页数
    * @param pageSize 一页显示多少行
    * @param offset 计算分页的定位点
    * @param SelectNum 返回所需要的分页查询结果
    */

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
     */

    @Override
    public List<DepartmentUnauditedSelect> QueryByDate(Date startTime,Date endTime,String department){

        return Mapper.QueryByDate(startTime,endTime,department);

    }

    @Override
    public List<DepartmentUnauditedSelect> SelectByDate(DepartmentUnauditedSelect DepartmentSelect,Integer page) {

        int offset = (page-1)*pageSize;
        return Mapper.SelectByDate(DepartmentSelect,offset,pageSize);

    }

    @Override
    public int getCount(Date startTime,Date endTime,String department){

        return  Mapper.getCount(startTime,endTime,department);
    }




}
