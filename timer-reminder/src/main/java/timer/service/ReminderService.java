package timer.service;

import timer.domain.Report;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/24/2017.
 */
public interface ReminderService {
    List<Report> queryReport(Date jmt,int role);
    void setMessage( int role);
}
