package edu.heu.soft.service;

import edu.heu.soft.domain.PersonSelectName;

import java.util.List;

/**
 * Created by new on 17-2-24.
 */

public interface PersonSelectNameService {


     /*
    *
    * @param PersonSelectName  SelectNotLeader  不是leader的查询结果
    * @param PersonSelectName  SelectLeader  是leader的查询结果
    * @param PersonSelectName  SelectAdmin  是admin的查询结果
    * @param Integer Leader 判断是否为leader，admin
    * @return List<PersonSelectName> SelectName 返回查询后的结果，作为下拉框的数据
    */


    List<PersonSelectName>SelectName(PersonSelectName SelectNotLeader, PersonSelectName SelectLeader, PersonSelectName SelectAdmin, Integer Leader, String cook);

    /*
    *@param Leader 查找leader
    * return int Select 返回leader的值
    */

    Integer SelectLeader(Integer Leader, String cook);

    /*
    * @param PersonSelectName SelectNotLeader 不是leader的查询方法
    * @return PersonSelectName 返回查询结果
     */

    List<PersonSelectName>SelectNameNotLeader(PersonSelectName SelectLeader, String cook);

    /*
    * @param PersonSelectName SelectLeader 是leader的查询方法
    * @return PersonSelectName 返回查询结果
     */
    List<PersonSelectName>SelectNameLeader(PersonSelectName SelectLeader, String cook);

    /*
    * @param PersonSelectName SelectAdmin 是Admin的查询方法
    * @return PersonSelectName 返回查询结果
     */
    List<PersonSelectName>SelectNameAdmin(PersonSelectName SelectAdmin, String cook);
}
