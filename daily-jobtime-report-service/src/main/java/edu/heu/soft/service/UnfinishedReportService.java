package edu.heu.soft.service;




import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mjrt on 2/26/2017.
 */

public interface UnfinishedReportService {
    List<Date> query(String name);
    Map<String, List<Date> > queryDepartment(String departmentName);
    Map<String, List<Date> > queryBatch(List<String> names);
}
