package org.link.advertise.core.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: changmingjiang
 * @Date: 2020/6/19 15:33
 */
@Data
public class CommonInfo {
    private Date createTime;
    private Date modifyTime;
    private Boolean deleteFlag;
}
