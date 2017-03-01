package edu.heu.soft.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by new on 17-2-21.
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonSelectByDate {



    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date jmt;
    private double workLoad;
    private double overTime;
    private double num;




}
