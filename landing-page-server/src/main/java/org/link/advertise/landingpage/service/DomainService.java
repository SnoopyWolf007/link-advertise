package org.link.advertise.landingpage.service;

import org.link.advertise.core.dto.PageDTO;
import org.link.advertise.core.entity.DomainInfo;
import org.link.advertise.landingpage.dto.DomainDTO;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 18:19
 */
public interface DomainService {

    void add(DomainInfo domainInfo);

    void del(Long id);

    DomainDTO find(String owner, PageDTO pageDTO);
}
