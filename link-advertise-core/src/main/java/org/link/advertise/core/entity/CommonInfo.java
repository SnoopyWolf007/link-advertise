package org.link.advertise.core.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/19 15:33
 */
@Data
public class CommonInfo {
    private Date createTime;
    private Date modifyTime;
    private Boolean deleteFlag;
}
