package edu.heu.soft.service;

import edu.heu.soft.domain.DepartmentUnauditedSelect;
import edu.heu.soft.domain.DepartmentUnauditedSelectDepartment;

import java.util.List;

/**
 * Created by new on 17-2-26.
 */
public interface DepartmentUnauditedSelectDepartmentService {
    /*
    *无参数查询
     */

    List<DepartmentUnauditedSelectDepartment> SelectDepartment();
}
