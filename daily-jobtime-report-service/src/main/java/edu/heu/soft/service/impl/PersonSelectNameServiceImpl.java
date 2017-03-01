package edu.heu.soft.service.impl;

import edu.heu.soft.domain.*;
import edu.heu.soft.service.PersonSelectByDateService;
import edu.heu.soft.service.PersonSelectNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by new on 17-2-21.
 */
@Service
public class PersonSelectNameServiceImpl implements PersonSelectNameService {
    @Autowired
    private PersonSelectNameMapper Mapper;


      /*
    *
    *  PersonSelectName  SelectNotLeader  不是leader的查询结果
    *  PersonSelectName  SelectLeader  是leader的查询结果
    *  Integer Leader 判断是否为leader，0为否，1为是
    *  List<PersonSelectName> SelectName 返回查询后的结果，作为下拉框的数据
    */

    /*
    * Leader 查找leader
    * return int Select 返回leader的值
    */

    /*
    *  PersonSelectName SelectNotLeader 不是leader的查询方法
    *  PersonSelectName 返回查询结果
     */

    /*
    *  PersonSelectName SelectLeader 是leader的查询方法
    *  PersonSelectName 返回查询结果
     */








    @Override
    public Integer SelectLeader(Integer Leader){


        return Mapper.SelectLeader(Leader);

    }



    @Override
    public List<PersonSelectName> SelectName(PersonSelectName SelectNotLeader,PersonSelectName SelectLeader,Integer Leader){


            return Mapper.SelectName(SelectNotLeader,SelectLeader,Leader);

    }

    @Override
    public List<PersonSelectName> SelectNameNotLeader(PersonSelectName SelectNotLeader){

        return Mapper.SelectNameNotLeader(SelectNotLeader);
    }

    @Override
    public List<PersonSelectName>SelectNameLeader(PersonSelectName SelectLeader){

        return Mapper.SelectNameLeader(SelectLeader);
    }









}


