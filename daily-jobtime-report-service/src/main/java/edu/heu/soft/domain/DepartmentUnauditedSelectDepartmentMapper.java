package edu.heu.soft.domain;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by new on 17-2-26.
 */
@Service
public interface DepartmentUnauditedSelectDepartmentMapper {

    /*
    *无条件查询方法
     */
    List<DepartmentUnauditedSelectDepartment> SelectDepartment();

}
