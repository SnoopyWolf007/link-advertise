package org.link.advertise.core.entity;

import lombok.Data;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/18 15:14
 */
@Data
public class LoginInfo {
    /**
     * 登录信息
     * */

    private String personnelId;
    private String loginName;
    private String password;
}
