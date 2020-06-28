package org.link.advertise.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 18:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LandingPageInfo extends CommonInfo {
    private Long id;
    private Long domainId;
    private String landingPageUrl;
    private String landingPageMd5;
    private String landingPageParams;
    private String creatorCode;
}
