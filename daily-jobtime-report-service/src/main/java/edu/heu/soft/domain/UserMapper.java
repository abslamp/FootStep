package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by new on 17-2-16.
 */

public interface UserMapper {
    User findByName(@Param("name") String name);
    List<User> findByDepartment(String DepartmentName);
    int insert(@Param("name") String name, @Param("age") Integer age);
    void update(@Param("name") String name, @Param("age") Integer age);
    void delete(@Param("id") Long id);
}
