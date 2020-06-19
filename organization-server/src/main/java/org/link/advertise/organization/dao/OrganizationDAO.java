package org.link.advertise.organization.dao;

import org.apache.ibatis.annotations.*;
import org.link.advertise.core.entity.OrganizationInfo;

import java.util.List;

/**
 * @Author: changmingjiang
 * @Date: 2020/6/19 15:01
 */
public interface OrganizationDAO {

    @Insert({"INSERT INTO `t_organization_info` (`code`, `name`, `parent_code`, `level`, " ,
            "`create_time`, `modify_time`, `delete_flag`) " ,
            "VALUES (#{code}, #{name}, #{parentCode}, #{level}, " ,
            "NOW(), NOW(), 0)"})
    @Options(useGeneratedKeys = true, keyProperty = "code", keyColumn = "code")
    int add(OrganizationInfo organizationInfo);

    @Update({"UPDATE t_organization_info SET delete_flag = 1 WHERE `code` = #{code}"})
    int delete(@Param("code") String code);

    @Select({"SELECT `code`,`name`,`parent_code`,`level`," ,
            "`create_time`,`modify_time`,`delete_flag` " ,
            "FROM t_organization_info"})
    List<OrganizationInfo> findAll();
}
