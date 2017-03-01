package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Root node : superiorId == id
 * No filter, no find by condition(except ID)
 * Reject deletetion on non-leaves
 *
 * Created by LZMA on 17-2-20.
 */


public interface DepartmentMapper {

    Department findById(Long id);
    List<Department> findAll();
    int update(@Param("id") Long id, @Param("dept") Department dept);
    int clearLeader(String deptName);
    int setLeader(String name);
    int insert(Department target);
    int delete(Long id);

}
