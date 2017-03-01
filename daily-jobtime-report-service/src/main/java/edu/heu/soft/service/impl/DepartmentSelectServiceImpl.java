package edu.heu.soft.service.impl;

import edu.heu.soft.domain.DepartmentSelect;
import edu.heu.soft.domain.DepartmentSelectMapper;
import edu.heu.soft.service.DepartmentSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by new on 17-2-26.
 */
@Service
public class DepartmentSelectServiceImpl implements DepartmentSelectService{

    @Autowired
    DepartmentSelectMapper mapper;

    /*
    *无参数查询，使用mapper中的查询语句
     */

    @Override
    public List<DepartmentSelect> Select()
    {
        return mapper.Select();
    }
}
