package demo.service;

import demo.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LZMA on 2017/2/18.
 */

@Service
public interface ProjectService {

    // 查询只有基本信息，其他信息编辑时AJAX
    List<Project> query(Project cond, int page);
    Project queryById(Long id);
    int getCount(Project cond);
    // AJAX参与部门
    List<ProjectAndDepartment> queryDepartmentLink(String projectName);
    // AJAX人员
    List<ProjectAndUser> queryUserLink(String projectName);
    List<String> queryUserStringLink(String projectName);
    List<String> queryDepartmentUserString(String projectName);
    // AJAX PRP阶段
    List<ProjectAndPrp> queryPrpLink(String projectName);
    List<Prp> queryAllPrp();

    // 修改基本信息
    int update(Long id, Project replace);
    // 修改参与部门
    int updateDepartmentLink(String projectName, String departmentName);
    // 修改参与人员
    int updateUserLink(String projectName, String[] userNames);
    // 修改PRP阶段
    int updatePrpLink(String projectName, String[] prpNames);

    // 增加时不绑定部门，人员，PRP的形式
    int insert(Project target);
}
