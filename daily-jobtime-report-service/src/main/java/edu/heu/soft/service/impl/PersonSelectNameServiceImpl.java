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
    * Leader 查找leader
    * return int Select 返回leader的值
    */


    @Override
    public Integer SelectLeader(Integer Leader,String cook){


        return Mapper.SelectLeader(Leader,cook);

    }



    /*
    *
    * @param PersonSelectName  SelectNotLeader  不是leader的查询结果
    * @param PersonSelectName  SelectLeader  是leader的查询结果
    * @param PersonSelectName  SelectAdmin  是admin的查询结果
    * @param Integer Leader 判断是否为leader，admin
    * @return List<PersonSelectName> SelectName 返回查询后的结果，作为下拉框的数据
    */

    @Override
    public List<PersonSelectName> SelectName(PersonSelectName SelectNotLeader,PersonSelectName SelectLeader,PersonSelectName SelectAdmin,Integer Leader,String cook){


            return Mapper.SelectName(SelectNotLeader,SelectLeader,SelectAdmin,Leader,cook);

    }



     /*
     *  PersonSelectName SelectNotLeader 不是leader的查询方法
     *  PersonSelectName 返回查询结果
    */


    @Override
    public List<PersonSelectName> SelectNameNotLeader(PersonSelectName SelectNotLeader,String cook){

        return Mapper.SelectNameNotLeader(SelectNotLeader,cook);
    }

    /*
    *  PersonSelectName SelectLeader 是leader的查询方法
    *  PersonSelectName 返回查询结果
    */
    @Override
    public List<PersonSelectName>SelectNameLeader(PersonSelectName SelectLeader,String cook){

        return Mapper.SelectNameLeader(SelectLeader,cook);
    }


    /*
    * @param PersonSelectName SelectAdmin 是Admin的查询方法
    * @return PersonSelectName 返回查询结果
     */
     @Override
    public List<PersonSelectName>SelectNameAdmin(PersonSelectName SelectAdmin,String cook){

        return  Mapper.SelectNameAdmin(SelectAdmin,cook);
     }







}


