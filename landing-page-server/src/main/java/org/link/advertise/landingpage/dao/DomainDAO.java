package org.link.advertise.landingpage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.link.advertise.core.entity.DomainInfo;

import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 18:15
 */
public interface DomainDAO {

    @Select({"INSERT INTO `t_domain_info` ",
            "(`domain_url`, `domain_md5`, `owners`, `create_time`, `modify_time`) ",
            "VALUES (#{domainUrl}, #{domainMd5}, #{owners}, NOW(), NOW())"})
    int insert(DomainInfo domainInfo);

    @Update({"UPDATE t_domain_info SET delete_flag = 1 WHERE id = #{id}"})
    int delete(@Param("id") Long id);

    @Select({"SELECT `id`, `domain_url`, `domain_md5`, `owners`, ",
            "`create_time`, `modify_time`, `delete_flag` ",
            "FROM t_domain_info",
            "WHERE FIND_IN_SET(${owner}, `owners`)",
            "ORDER BY id",
            "LIMIT ${offset}, ${pageSize}"
    })
    List<DomainInfo> find(@Param("owner") String owner, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    @Select({"SELECT count(`id`)",
            "FROM t_domain_info",
            "WHERE FIND_IN_SET(${owner}, `owners`)"
    })
    Integer count(@Param("owner") String owner);

}
