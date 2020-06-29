package org.link.advertise.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/29 10:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FormCollectionInfo extends CommonInfo {
    private Long id;
    private String channel;
    private String account;
    private String url;
    private String urlMd5;
    private String remakeUrl;
    private String remakeUrlMd5;
    private String qq;
    private String weChat;
    private String phone;
    private String userName;
}
