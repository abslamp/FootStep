package edu.heu.soft.service;

import edu.heu.soft.domain.Department;

import java.util.List;

/**
 * Created by LZMA on 2017/2/18.
 */


public interface DepartmentService {
    Department queryById(Long id);
    List<Department> queryAll();
    int update(Long id, Department replace);
    int delete(Long id);
    int insert(Department target);
}
