package edu.heu.soft.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/19/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Report  {

    private Long id;
    private String name;//写日报的人名
    private String project;
    private  String prp;
    private String task;     //length = 4096  任务
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date jmt ;
    private double workLoad;//工作量
    private double overTime;//加班数
    private String state;//未审批，未通过，已通过



}
