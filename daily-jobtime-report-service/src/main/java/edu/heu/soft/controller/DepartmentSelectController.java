package edu.heu.soft.controller;

import edu.heu.soft.domain.DepartmentSelect;
import edu.heu.soft.service.DepartmentSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.List;

/**
 * Created by new on 17-2-26.
 */

@RestController
@RequestMapping("/DepartmentSelect")
public class DepartmentSelectController {

    @Autowired
    DepartmentSelectService service;

    /*
    *

    * @return List<DepartmentSelect> Select 无条件查询 返回所需求的部门 作为下拉框数据源
    */




    @RequestMapping(value = "/select")

    public List<DepartmentSelect> Select()
    {
            return service.Select();
    }


}
