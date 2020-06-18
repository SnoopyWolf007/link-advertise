package org.link.advertise.core.entity;

import lombok.Data;

/**
 * @Author: changmingjiang
 * @Date: 2020/6/18 14:54
 */
@Data
public class OrganizationInfo {
    /**
     * 组织架构信息
     * */

    private String id;
    private String name;
    private String code;
    private String parentId;
    private Integer level;
}
