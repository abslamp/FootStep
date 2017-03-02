package edu.heu.soft.service.impl;

import edu.heu.soft.domain.PersonSelectByDate;
import edu.heu.soft.domain.PersonSelectByDateMapper;
import edu.heu.soft.service.PersonSelectByDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by new on 17-2-21.
 */
@Service
public class PersonSelectByDateServiceImpl implements PersonSelectByDateService {
    @Autowired
    private PersonSelectByDateMapper Mapper;

    static int pageSize=5;


    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param name 名字
    * return QueryByDate 个人日报查询结果
    * 使用psb 来实现汇总的行累加存储 之后将这一行加入之前查询到的数组psbd中
    */



    @Override
    public List<PersonSelectByDate> QueryByDate(Date startTime,Date endTime,String name)
    {
        List<PersonSelectByDate> psbd =Mapper.QueryByDate(startTime,endTime,name);
        PersonSelectByDate psb = new PersonSelectByDate(); //total row
        psb.setNum(0);
        psb.setOverTime(0);
        psb.setWorkLoad(0);
        for(PersonSelectByDate p : psbd) {
            psb.setNum(psb.getNum()+p.getNum());
            psb.setWorkLoad(psb.getWorkLoad()+p.getWorkLoad());
            psb.setOverTime(psb.getOverTime()+p.getOverTime());
        }
        psbd.add(psb);

        return psbd;
    }
     /*
    *
    * @param DepartmentSelect 数据源
    * @param page 分页查询的页数
    * @param pageSize 一页显示多少行
    * @param offset 计算分页的定位点
    * @param SelectByDate 返回所需要的分页查询结果
    */


    @Override
    public List<PersonSelectByDate> SelectByDate(PersonSelectByDate PersonSelect,Integer page) {

        int offset = (page-1)*pageSize;
        return Mapper.SelectByDate(PersonSelect,offset,pageSize);

    }


    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param name 名字
     */


    @Override
    public int getCount(Date startTime,Date endTime,String name){

        return  Mapper.getCount(startTime,endTime,name);
    }





}


