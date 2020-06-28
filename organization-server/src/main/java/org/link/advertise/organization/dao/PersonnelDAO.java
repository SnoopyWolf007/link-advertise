package org.link.advertise.organization.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.link.advertise.core.entity.PersonnelInfo;

import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/19 15:01
 */
public interface PersonnelDAO {

    @Insert({"INSERT INTO `t_personnel_info` ",
            "(`code`, `name`, `phone`, `id_card_no`, ",
            "`organization_code`, `create_time`, `modify_time`, `delete_flag`) ",
            "VALUES (#{code}, #{name}, #{phone}, #{idCardNo}, ",
            "#{organizationCode}, NOW(), NOW(), #{deleteFlag})",
            "ON DUPLICATE KEY UPDATE `name`='', `phone`='', ",
            "`organization_code`=#{code}, `modify_time` = NOW(),`delete_flag` = #{deleteFlag}"})
    int insert(PersonnelInfo personnelInfo);

    @Update({"UPDATE `t_personnel_info` SET `delete_flag` = 1 WHERE `code` = #{code}"})
    int delete(@Param("code") String code);

    @Select({"SELECT `code`, `name`, `phone`, `id_card_no`, ",
            "`organization_code`, `create_time`, `modify_time`, `delete_flag` ",
            "FROM `t_personnel_info`",
            "WHERE `code` = #{code}"
    })
    PersonnelInfo getByCode(@Param("code") String code);

    @Select({"SELECT `code`, `name`, `phone`, `id_card_no`, ",
            "`organization_code`, `create_time`, `modify_time`, `delete_flag` ",
            "FROM `t_personnel_info`"})
    List<PersonnelInfo> findAll();

    @Select({"SELECT `code`, `name`, `phone`, `id_card_no`, ",
            "`organization_code`, `create_time`, `modify_time`, `delete_flag` ",
            "FROM `t_personnel_info`",
            "WHERE `organization_code` = #{orgCode}"
    })
    List<PersonnelInfo> findCurrentChild(@Param("orgCode") String orgCode);

    @Select({"<script>",
            "SELECT `code`, `name`, `phone`, `id_card_no`, ",
            "`organization_code`, `create_time`, `modify_time`, `delete_flag` ",
            "FROM `t_personnel_info`",
            "WHERE `organization_code` IN ",
            "<foreach collection='orgCodes' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</script>"
    })
    List<PersonnelInfo> findByOrgCodes(@Param("orgCodes") List<String> orgCodes);
}
