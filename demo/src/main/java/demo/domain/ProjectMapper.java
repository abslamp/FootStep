package demo.domain;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LZMA on 2017/2/18.
 */
public interface ProjectMapper {

    Project findById(Long id);
    List<Project> find(@Param("cond") Project cond, @Param("offset") int offset, @Param("total") int total);
    int getCount(Project cond);

    List<ProjectAndPrp> findPrpByProjectName(String name);
    List<ProjectAndUser> findUserByProjectName(String name);
    List<String> findUserStringByProjectName(String name);
    List<ProjectAndDepartment> findDepartmentByProjectName(String name);

    // 临时使用的User表查询，供编辑用
    List<User> findUserByDept(String dept);
    List<String> findUserStringByDept(String dept);
    List<Prp> findAllPrp();
    // 编辑用DEPT列表本机就有,不加

    int insert(Project project);

    // 更新用
    int update(@Param("id") Long id, @Param("replace") Project replace);

//    int insertPrpLink(@Param("projectId")Long projectId, @Param("prp")Prp prp);
//    int insertDepartmentLink(@Param("projectId")Long projectId, @Param("prp")Department department);
//    int insertUserLink(@Param("projectId")Long projectId, @Param("prp")User user);
    int insertPrpLink(ProjectAndPrp target);
    int insertDepartmentLink(ProjectAndDepartment target);
    int insertUserLink(ProjectAndUser target);

    // 一对多关系更新
    int delete(Long id);
    int deleteDepartmentLink(String projectName);
    int deleteUserLink(String projectName);
    int deletePrpLink(String projectName);

}
