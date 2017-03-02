package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-21.
 */

@Service
public interface PersonSelectNameMapper {


    /*
    *
    * @param PersonSelectName  SelectNotLeader  不是leader的查询结果
    * @param PersonSelectName  SelectLeader  是leader的查询结果
    * @param PersonSelectName  SelectAdmin  是admin的查询结果
    * @param Integer Leader 判断是否为leader，admin
    * @return List<PersonSelectName> SelectName 返回查询后的结果，作为下拉框的数据
    */


    List<PersonSelectName>SelectName(@Param("SelectNotLeader") PersonSelectName SelectNotLeader, @Param("SelectLeader") PersonSelectName SelectLeader, @Param("SelectAdmin") PersonSelectName SelectAdmin, @Param("Leader") Integer Leader, @Param("cook") String cook);
    /*
    *@param Leader 查找leader
    * return int Select 返回leader的值
    */


    Integer SelectLeader(@Param("Leader") Integer Leader, @Param("cook") String cook);
    /*
    * @param PersonSelectName SelectNotLeader 不是leader的查询方法
    * @return PersonSelectName 返回查询结果
     */




    List<PersonSelectName>SelectNameNotLeader(@Param("SelectNotLeader") PersonSelectName SelectNotLeader, @Param("cook") String cook);
    /*
    * @param PersonSelectName SelectLeader 是leader的查询方法
    * @return PersonSelectName 返回查询结果
    */
    List<PersonSelectName>SelectNameLeader(@Param("SelectLeader") PersonSelectName SelectLeader, @Param("cook") String cook);

     /*
    * @param PersonSelectName SelectAdmin 是Admin的查询方法
    * @return PersonSelectName 返回查询结果
     */

    List<PersonSelectName>SelectNameAdmin(@Param("SelectAdmin") PersonSelectName SelectAdmin, @Param("cook") String cook);
}