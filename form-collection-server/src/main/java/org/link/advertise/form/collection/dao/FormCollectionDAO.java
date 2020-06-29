package org.link.advertise.form.collection.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.link.advertise.core.entity.FormCollectionInfo;

import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/29 10:31
 */
public interface FormCollectionDAO {

    @Insert({"INSERT INTO `t_form_collection_info` ",
            "(`channel`, `account`, `url`, ",
            "`url_md5`, `remake_url`, `remake_url_md5`, `qq`, ",
            "`we_chat`, `phone`, `user_name`, `create_time`, ",
            "`modify_time`, `delete_flag`) ",
            "VALUES (#{channel}, #{account}, #{url}, ",
            "#{urlMd5}, #{remakeUrl}, #{remakeUrlMd5}, #{qq}, ",
            "#{weChat}, #{phone}, #{userName}, NOW(), ",
            "NOW())"
    })
    int insert(FormCollectionInfo formCollectionInfo);

    @Select({"SELECT `id`, `channel`, `account`, `url`, `url_md5`, `remake_url`, `remake_url_md5`, `qq`, ",
            "`we_chat`, `phone`, `user_name`, `create_time`, `modify_time`, `delete_flag` ",
            "FROM t_form_collection_info",
            "ORDER BY `id`",
            "LIMIT ${offset}, ${limit}"
    })
    List<FormCollectionInfo> find(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select({"SELECT COUNT(`id`)",
            "FROM t_form_collection_info"
    })
    Integer count();

}
