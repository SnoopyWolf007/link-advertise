package org.link.advertise.organization.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.entity.PersonnelInfo;
import org.link.advertise.core.exception.BizException;
import org.link.advertise.organization.dao.PersonnelDAO;
import org.link.advertise.organization.service.PersonnelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: changmingjiang
 * @Date: 2020/6/19 15:02
 */
@Slf4j
@Service
@AllArgsConstructor
public class PersonnelServiceImpl implements PersonnelService {

    private final PersonnelDAO personnelDAO;

    @Override
    public void insert(PersonnelInfo personnelInfo) throws BizException {

    }

    @Override
    public void update(PersonnelInfo personnelInfo) throws BizException {

    }

    @Override
    public void delete(String code) throws BizException {

    }

    @Override
    public PersonnelInfo getByCode(String code) throws BizException {
        return null;
    }

    @Override
    public List<PersonnelInfo> findAll() throws BizException {
        return null;
    }

    @Override
    public List<PersonnelInfo> findCurrentChild(String organizationCode) throws BizException {
        return null;
    }

    @Override
    public List<PersonnelInfo> findAllChild(String organizationCode) throws BizException {
        return null;
    }
}
