package org.link.advertise.organization.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.link.advertise.core.entity.OrganizationInfo;
import org.link.advertise.core.exception.BizException;
import org.link.advertise.organization.dao.OrganizationDAO;
import org.link.advertise.organization.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author: changmingjiang
 * @Date: 2020/6/19 15:02
 */
@Slf4j
@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDAO organizationDAO;

    @Override
    public void insert(OrganizationInfo organizationInfo) throws BizException {
        if (Objects.isNull(organizationInfo)) {
            return;
        }
        organizationDAO.add(organizationInfo);
    }

    @Override
    public void update(OrganizationInfo organizationInfo) throws BizException {

    }

    @Override
    public void delete(String code) throws BizException {
        if (Strings.isBlank(code)) {
            return;
        }
        organizationDAO.delete(code);
    }

    @Override
    public OrganizationInfo getByCode(String code) throws BizException {
        return null;
    }

    @Override
    public List<OrganizationInfo> findAll() throws BizException {
        return null;
    }

    @Override
    public List<OrganizationInfo> findCurrentChild(String code) throws BizException {
        return null;
    }

    @Override
    public List<OrganizationInfo> findAllChild(String code) throws BizException {
        return null;
    }
}
