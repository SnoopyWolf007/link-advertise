package org.link.advertise.organization.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.link.advertise.core.entity.PersonnelInfo;
import org.link.advertise.core.exception.BizException;
import org.link.advertise.organization.dao.PersonnelDAO;
import org.link.advertise.organization.service.OrganizationService;
import org.link.advertise.organization.service.PersonnelService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/19 15:02
 */
@Slf4j
@Service
@AllArgsConstructor
public class PersonnelServiceImpl implements PersonnelService {

    private final PersonnelDAO personnelDAO;
    private final OrganizationService organizationService;

    @Override
    public void insert(PersonnelInfo personnelInfo) throws BizException {
        if (Objects.isNull(personnelInfo)) {
            return;
        }
        personnelDAO.insert(personnelInfo);
    }

    @Override
    public void update(PersonnelInfo personnelInfo) throws BizException {
        if (Objects.isNull(personnelInfo)) {
            return;
        }

    }

    @Override
    public void delete(String code) throws BizException {
        if (Strings.isBlank(code)) {
            return;
        }
        personnelDAO.delete(code);
    }

    @Override
    public PersonnelInfo getByCode(String code) throws BizException {
        if (Strings.isBlank(code)) {
            return null;
        }
        return personnelDAO.getByCode(code);
    }

    @Override
    public List<PersonnelInfo> findAll() throws BizException {
        return personnelDAO.findAll();
    }

    @Override
    public List<PersonnelInfo> findCurrentChild(String organizationCode) throws BizException {
        if (Strings.isBlank(organizationCode)) {
            return new ArrayList<>();
        }
        return personnelDAO.findCurrentChild(organizationCode);
    }

    @Override
    public List<PersonnelInfo> findAllChild(String organizationCode) throws BizException {
        if (Strings.isBlank(organizationCode)) {
            return new ArrayList<>();
        }

        List<String> childCodeList = organizationService.getChildCodes(organizationCode, true);
        if (CollectionUtils.isEmpty(childCodeList)) {
            return new ArrayList<>();
        }

        return personnelDAO.findByOrgCodes(childCodeList);
    }
}
