package edu.heu.soft.service;

import edu.heu.soft.domain.User;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * Created by new on 17-2-23.
 */
public interface SelectPeopleService {

 List<User> query(String id, String department, String name, String gender, Integer role, String edu, int page);
 int getCount(String department, String name, String gender, Integer role, String edu);
 List<User> queryUserDepartment();
 List<User> queryUserEdu();

 String insertPeople(User user);
 void deletePeople(Long id);
 void updatePeople(Long id, String password, String department, String name, String gender, int role, String edu);
 User queryUserName(Long id);
}
