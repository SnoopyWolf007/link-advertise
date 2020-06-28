package org.link.advertise.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/18 14:54
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrganizationInfo extends CommonInfo {
    /**
     * 组织架构信息
     * */

    private String code;
    private String name;
    private String parentCode;
    private Integer level;
}
