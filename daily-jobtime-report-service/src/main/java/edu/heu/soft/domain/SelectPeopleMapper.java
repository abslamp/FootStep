package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * Created by new on 17-2-23.
 */
public interface SelectPeopleMapper {

    List<User> findUser(@Param("id") String id, @Param("department") String department, @Param("name") String name, @Param("gender") String gender, @Param("role") Integer role, @Param("edu") String edu, @Param("offset") int offset, @Param("total") int total);
    int getCount(@Param("department") String department, @Param("name") String name, @Param("gender") String gender, @Param("role") Integer role, @Param("edu") String edu);
    List<User> findUserDepartment();
    List<User> findUserEdu();


    int insertPeople(@Param("password") String password, @Param("department") String department, @Param("name") String name, @Param("gender") String gender, @Param("role") int role, @Param("edu") String edu);
    void deletePeople(@Param("id") Long id);
    void updatePeople(@Param("id") Long id, @Param("password") String password, @Param("department") String department, @Param("name") String name, @Param("gender") String gender, @Param("role") int role, @Param("edu") String edu);
    User findUserName(@Param("id") Long id);
}
