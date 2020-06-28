package org.link.advertise.organization.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.link.advertise.core.entity.OrganizationInfo;
import org.link.advertise.core.exception.BizException;
import org.link.advertise.organization.dao.OrganizationDAO;
import org.link.advertise.organization.service.OrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author jcm1024@163.com
 * @date 2020/6/19 15:02
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
        organizationDAO.insert(organizationInfo);
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
        if (Strings.isBlank(code)) {
            return null;
        }
        return organizationDAO.getByCode(code);
    }

    @Override
    public List<OrganizationInfo> findAll() throws BizException {
        return organizationDAO.findAll();
    }

    @Override
    public List<OrganizationInfo> findCurrentChild(String code) throws BizException {
        if (Strings.isBlank(code)) {
            return new ArrayList<>();
        }
        return organizationDAO.findCurrentChild(code);
    }

    @Override
    public List<String> getChildCodes(String code, boolean incSelf) {
        if (Strings.isBlank(code)) {
            return new ArrayList<>();
        }
        String chileNodeStr = organizationDAO.getChileNodeStr(code);
        if (Strings.isBlank(chileNodeStr)) {
            return new ArrayList<>();
        }

        String[] split = chileNodeStr.split(",");
        if (2 == split.length) {
            return new ArrayList<>();
        }
        String[] nodeArr = null;
        if (incSelf) {
            nodeArr = Arrays.copyOfRange(split, 1, split.length);
        } else {
            nodeArr = Arrays.copyOfRange(split, 2, split.length);
        }
        List<String> nodeList = Arrays.asList(nodeArr);
        return nodeList;
    }

    @Override
    public List<OrganizationInfo> findAllChild(String code) throws BizException {
        if (Strings.isBlank(code)) {
            return new ArrayList<>();
        }

        List<String> nodeList = getChildCodes(code, false);
        if (CollectionUtils.isEmpty(nodeList)) {
            return new ArrayList<>();
        }

        return organizationDAO.findByCodes(nodeList);
    }

}
