package edu.heu.soft.controller;

import edu.heu.soft.domain.PersonSelectByDate;
import edu.heu.soft.domain.PersonSelectName;
import edu.heu.soft.service.PersonSelectByDateService;
import edu.heu.soft.service.PersonSelectNameService;
import org.apache.ibatis.jdbc.Null;
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
@RequestMapping("/PersonSelectName")
public class PersonSelectNameController {


    @Autowired
    PersonSelectNameService service;


    /*
    *
    * @param PersonSelectName  SelectNotLeader  不是leader的查询结果
    * @param PersonSelectName  SelectLeader  是leader的查询结果
    * @param PersonSelectName  SelectAdmin  是admin的查询结果
    * @param Integer Leader 判断是否为leader，admin
    * @return List<PersonSelectName> SelectName 返回查询后的结果，作为下拉框的数据
    */
    @RequestMapping(value = "/name")

    public List<PersonSelectName> SelectName(PersonSelectName SelectNotLeader,PersonSelectName SelectLeader,PersonSelectName SelectAdmin,Integer Leader,String cook){



        if (service.SelectLeader(Leader,cook)==2)
            return service.SelectNameLeader(SelectLeader,cook);
        else if (service.SelectLeader(Leader,cook)==0)
            return service.SelectNameAdmin(SelectAdmin,cook);
        else if (service.SelectLeader(Leader,cook)==1)
            return service.SelectNameAdmin(SelectAdmin,cook);
        else
            return service.SelectNameNotLeader(SelectNotLeader,cook);
    }


    /*
    *@param Leader 查找leader
    * return int Select 返回leader的值
    */


    @RequestMapping(value ="leader")

    public int SelectLeader (int Leader,String cook)
    {
        return service.SelectLeader(Leader,cook);
    }

    /*
    * @param PersonSelectName SelectNotLeader 不是leader的查询方法
    * @return PersonSelectName 返回查询结果
     */


    @RequestMapping(value ="nameNotLeader")
    public List<PersonSelectName> SelectName1(PersonSelectName SelectNotLeader,String cook){
        return service.SelectNameNotLeader(SelectNotLeader,cook);
    }


    /*
    * @param PersonSelectName SelectLeader 是leader的查询方法
    * @return PersonSelectName 返回查询结果
     */
    @RequestMapping(value ="nameLeader")
    public List<PersonSelectName> SelectNameLeader(PersonSelectName SelectLeader,String cook){
        return service.SelectNameLeader(SelectLeader,cook);
    }

     /*
    * @param PersonSelectName SelectAdmin 是Admin的查询方法
    * @return PersonSelectName 返回查询结果
     */

     @RequestMapping(value="admin")
    public List<PersonSelectName> SelectNameAdmin(PersonSelectName SelectAdmin,String cook){
         return service.SelectNameAdmin(SelectAdmin,cook);
     }



}
