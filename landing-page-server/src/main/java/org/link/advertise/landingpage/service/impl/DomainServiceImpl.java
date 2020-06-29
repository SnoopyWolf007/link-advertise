package org.link.advertise.landingpage.service.impl;

import com.alibaba.druid.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.dto.PageDTO;
import org.link.advertise.core.entity.DomainInfo;
import org.link.advertise.core.util.Md5Util;
import org.link.advertise.core.util.PageUtils;
import org.link.advertise.landingpage.dao.DomainDAO;
import org.link.advertise.landingpage.dto.DomainDTO;
import org.link.advertise.landingpage.service.DomainService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 18:21
 */
@Slf4j
@Service
@AllArgsConstructor
public class DomainServiceImpl implements DomainService {

    private final DomainDAO domainDAO;

    @Override
    public void add(DomainInfo domainInfo) {
        if (Objects.isNull(domainInfo)) {
            return;
        }
        String md5 = Md5Util.md5(domainInfo.getDomainUrl());
        domainInfo.setDomainMd5(md5);

        domainDAO.insert(domainInfo);
    }

    @Override
    public void del(Long id) {
        if (Objects.isNull(id)) {
            return;
        }
        domainDAO.delete(id);
    }

    @Override
    public DomainDTO find(String owner, PageDTO pageDTO) {
        if (StringUtils.isEmpty(owner) || Objects.isNull(pageDTO)
                || pageDTO.verifyParam()) {
            return new DomainDTO(pageDTO.getPage(), pageDTO.getPageSize());
        }

        Integer offset = (pageDTO.getPage() - 1) * pageDTO.getPageSize();
        Integer total = domainDAO.count(owner);

        DomainDTO domainDTO = PageUtils.getPageDTO(pageDTO, total, DomainDTO.class);
        if (Objects.isNull(domainDTO)) {
            return null;
        }

        domainDTO.setList(domainDAO.find(owner, offset, pageDTO.getPageSize()));
        return domainDTO;
    }
}
