package edu.heu.soft.service;

import edu.heu.soft.domain.ProjectWorkLoad;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/26/2017.
 */
public interface WorkLoadService {
    List<ProjectWorkLoad> queryByProject(String department , Date startDate , Date endDate);
}
