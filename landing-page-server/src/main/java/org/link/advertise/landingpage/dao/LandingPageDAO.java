package org.link.advertise.landingpage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.link.advertise.core.entity.LandingPageInfo;

import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 18:16
 */
public interface LandingPageDAO {

    @Select({"INSERT INTO `t_landing_page_info` ",
            "(`domain_id`, `landing_page_url`, `landing_page_md5`, `landing_page_params`, ",
            "`create_time`, `modify_time`, `creator_code`) ",
            "VALUES (#{domainId}, #{landingPageUrl}, #{landingPageMd5}, #{landingPageParams}, ",
            "NOW(), NOW(), #{creatorCode})"})
    int insert(LandingPageInfo landingPageInfo);

    @Update({"UPDATE t_landing_page_info SET delete_flag = 1 WHERE id = #{id}"})
    int delete(@Param("id") Long id);

    @Select({"SELECT `id`, `domain_id`, `landing_page_url`, `landing_page_md5`, `landing_page_params`, ",
            "`create_time`, `modify_time`, `creator_code`, `delete_flag` ",
            "FROM t_landing_page_info",
            "WHERE creator_code = #{owner}",
            "ORDER BY `id`",
            "LIMIT ${offset}, ${pageSize}"
    })
    List<LandingPageInfo> find(@Param("owner") String owner, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    @Select({"SELECT count(`id`)",
            "FROM t_landing_page_info",
            "WHERE creator_code = #{owner}"
    })
    Integer count(@Param("owner") String owner);

}
