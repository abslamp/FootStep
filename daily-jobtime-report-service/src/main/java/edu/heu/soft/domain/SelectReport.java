package edu.heu.soft.domain;

import java.util.Date;

/**
 * Created by new on 17-2-23.
 */

public class SelectReport {


    private Long id;
    private String name;//写日报的人名
    private String project;
    private  String prp;
    private String task;     //length = 4096  任务
    private Date date ;
    private double workLoad;//工作量
    private double overTime;//加班数
    private String state = "UNAUDITED";//未审批，未通过，已用过
    private Date start;
    private Date end;
}
