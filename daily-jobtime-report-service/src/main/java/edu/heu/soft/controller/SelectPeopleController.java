package edu.heu.soft.controller;

import edu.heu.soft.domain.User;
import edu.heu.soft.service.SelectPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * Created by new on 17-2-23.
 */
@RestController
@RequestMapping("/SelectPeople")
public class SelectPeopleController {
    @Autowired
    SelectPeopleService service;
    /**
     * 查询员工信息
     * @Param id 查询员工ID
     * @Param department 查询部门
     * @Param name 查询员工姓名
     * @Param gender 查询员工性别
     * @Param role  查询员工是否为领导
     * @Param edu 查询员工学历
     * @Param page 分页查询页数
     * @return 将查询到的员工信息封装在User的pojo类中返回
     */
    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public List<User> query(String id,String department,String name,String gender,Integer role,String edu, Integer page){
        if(page==null) page=0;

       System.out.println(role);
       return service.query(id,department,name,gender,role,edu,page);
    }
    /**
     * 查询记录数
     * @Param
     * @return 返回查询到的记录条数
     */
    @RequestMapping(value = "/rowscount" )
    public int  rowsCount (String department,String name,String gender,Integer role,String edu){

        return service.getCount(department,name,gender,role,edu);
    }
    /**
     * 查询部门信息
     * @Param
     * @return
     */
    @RequestMapping(value = "/department")
    public List<User> queryUserDepartment(){

        return service.queryUserDepartment();
    }

    /**
     * 查询学历信息
     * @Param
     * @return
     */
    @RequestMapping(value = "/edu")
    public List<User> queryUserEdu(){


        return service.queryUserEdu();
    }


    /**
     * 插入人员信息
     * @Param
     * @return
     */
    @RequestMapping(value = "/insert" )
    public String insertPeople(User user){

        return service.insertPeople(user);
    }
    /**
     * 删除人员信息
     * @Param id
     * @return
     */

    @RequestMapping(value = "/delete" )
    public void deletePeople( Long id){

        service.deletePeople(id);
    }
    /**
     * 更新人员信息
     * @Param
     * @return
     */
    @RequestMapping(value = "/update" )
    public void updatePeople(String password,String department,String name,String gender,int role,String edu )
    {
        service.updatePeople(password,department,name,gender,role,edu);
    }

}
