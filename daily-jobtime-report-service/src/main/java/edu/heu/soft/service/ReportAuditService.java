package edu.heu.soft.service;

import edu.heu.soft.domain.Report;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mjrt on 2/26/2017.
 */
public interface ReportAuditService {
    List<Report> query(String name, String state, Date startDate, Date endDate);
    //Map<String,List<Report>> queryBatch(List<String> names , String state, Date startDate, Date endDate );
    List<Report> queryBatch(List<String> names, String state, Date startDate, Date endDate);
    //Map<String,List<Report>> queryBySubordinate(String leaderName,String state, Date startDate, Date endDate);
    List<Report> queryBySubordinate(String leaderName, String state, Date startDate, Date endDate);
    int update(Report report);
    List<String> querySubordinate(String leaderName);
    int audit(List<Integer> id, String state);
}
