package edu.heu.soft.service.impl;

import edu.heu.soft.domain.DepartmentUnauditedSelectDepartment;
import edu.heu.soft.domain.DepartmentUnauditedSelectDepartmentMapper;
import edu.heu.soft.service.DepartmentUnauditedSelectDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by new on 17-2-26.
 */
@Service
public class DepartmentUnauditedSelectDepartmentServiceImpl implements DepartmentUnauditedSelectDepartmentService {

    @Autowired
    private DepartmentUnauditedSelectDepartmentMapper mapper;

    /*
    *无参数查询，使用查询语句返回值
     */

    @Override
    public List<DepartmentUnauditedSelectDepartment> SelectDepartment()
    {
        return mapper.SelectDepartment();
    }

}
