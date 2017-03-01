package edu.heu.soft.domain;

import java.util.List;

/**
 * Created by mjrt on 2/26/2017.
 */
public interface ProjectAndDepartmentMapper {
    List<String> findProjectByDepartment(String department);
}
