package edu.heu.soft.controller;

import edu.heu.soft.domain.DepartmentUnauditedSelectDepartment;
import edu.heu.soft.service.DepartmentUnauditedSelectDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by new on 17-2-26.
 */

@RestController
@RequestMapping("/DepartmentUnauditedSelectDepartment")
public class DepartmentUnauditedSelectDepartmentController {
    @Autowired
    DepartmentUnauditedSelectDepartmentService service;


    /*
    * @return List<DepartmentUnauditedSelectDepartment> SelectDepartment 无条件查询 返回的值作为下拉框选项
    */


    @RequestMapping(value = "/department")

    public List<DepartmentUnauditedSelectDepartment> SelectDepartment(){
        return service.SelectDepartment();
    }



}
