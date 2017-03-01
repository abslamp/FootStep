package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/26/2017.
 */
public interface ReportAuditMapper {
    List<Report> findByProject(String project);
    List<Report> findByNameAndStateAndDate(@Param("name") String name, @Param("state") String state, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    List<Report> findByStateOrderByProjectAndName(String state);
    List<Report> findByNameAndDate(@Param("name") String name, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    int save(Report report);
    List<String> findSubordinate(String name);
    List<String> findEveryone();
    int audit(@Param("id") int id, @Param("state") String state);

}
