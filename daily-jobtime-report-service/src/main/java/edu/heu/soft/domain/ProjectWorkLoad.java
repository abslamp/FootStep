package edu.heu.soft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mjrt on 2/26/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectWorkLoad {
    private String projectName;
    private Double totalWorkLoad;
    private Double totalOverTime;
}
