package org.link.advertise.landingpage.service;

import org.link.advertise.core.entity.LandingPageInfo;
import org.link.advertise.landingpage.dto.LandingPageDTO;
import org.link.advertise.landingpage.dto.PageDTO;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 18:20
 */
public interface LandingPageService {

    void add(LandingPageInfo landingPageInfo);

    void del(Long id);

    LandingPageDTO find(String owner, PageDTO pageDTO);

}
