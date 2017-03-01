package edu.heu.soft.service.impl;

import edu.heu.soft.domain.SelectPeopleMapper;
import edu.heu.soft.domain.User;
import edu.heu.soft.service.SelectPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by new on 17-2-23.
 */
@Service
public class SelectPeopleServiceImpl implements SelectPeopleService {
    @Autowired
    SelectPeopleMapper mapper;
    static  int pageSize=5;

  @Override
  public List<User> query(String id,String department,String name,String gender,Integer role,String edu, int page) {

      int offset=(page-1)*pageSize;
      return mapper.findUser(id,department,name,gender,role,edu,offset,pageSize);
  }

    @Override
    public int getCount(String department,String name,String gender,Integer role,String edu) {
        return mapper.getCount(department,name, gender,role,edu);
    }

    @Override
    public List<User> queryUserDepartment() {

      return mapper.findUserDepartment();
    }

    @Override
    public List<User> queryUserEdu() {
        return mapper.findUserEdu();
    }



    @Override
    public String insertPeople(User user) {
        mapper.insertPeople(user.getPassWord(),user.getDepartment(),user.getName(),user.getGender(),user.getRole(),user.getEdu());
        return "success";
    }
    @Override
    public void deletePeople(Long id) {
        mapper.deletePeople(id);
    }
    @Override
    public void updatePeople(Long id,String password,String department,String name,String gender,int role,String edu)
    {
        mapper.updatePeople(id,password,department,name,gender,role,edu);
    }
    @Override
    public User queryUserName(Long id){
        return mapper. findUserName(id);
    }

}
