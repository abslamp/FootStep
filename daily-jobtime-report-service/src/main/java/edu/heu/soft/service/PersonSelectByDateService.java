package edu.heu.soft.service;

import edu.heu.soft.domain.PersonSelectByDate;
import io.swagger.models.auth.In;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/19/2017.
 */

public interface PersonSelectByDateService {


     /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param name 名字
    */
    List<PersonSelectByDate> QueryByDate(Date startTime, Date endTime, String name);
      /*
    *
    * @param SelectByDate 数据源
    * @param offset 分页页数
    * @param total 总计
    */

    List<PersonSelectByDate> SelectByDate(PersonSelectByDate PersonSelect, Integer page);

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param name 名字
     */


    int getCount(Date startTime, Date endTime, String name);



}
