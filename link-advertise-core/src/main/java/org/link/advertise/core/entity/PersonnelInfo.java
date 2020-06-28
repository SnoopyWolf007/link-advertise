package org.link.advertise.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/18 14:55
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PersonnelInfo extends CommonInfo{
    /**
     * 人员信息
     * */

    private String code;
    private String name;
    private String phone;
    private String idCardNo;
    private String organizationCode;
}
