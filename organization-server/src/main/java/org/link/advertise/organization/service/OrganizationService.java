package org.link.advertise.organization.service;

import org.link.advertise.core.entity.OrganizationInfo;
import org.link.advertise.core.exception.BizException;

import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/19 15:02
 */
public interface OrganizationService {
    /**
     * 插入
     *
     * @param organizationInfo
     */
    void insert(OrganizationInfo organizationInfo) throws BizException;

    /**
     * 更新
     *
     * @param organizationInfo
     */
    void update(OrganizationInfo organizationInfo) throws BizException;

    /**
     * 逻辑删除
     *
     * @param code
     */
    void delete(String code) throws BizException;

    /**
     * 通过code查询
     *
     * @param code
     */
    OrganizationInfo getByCode(String code) throws BizException;

    /***
     * 获取所有子节点code
     * @param code
     * */
    List<String> getChildCodes(String code, boolean incSelf);

    /**
     * 查询所有组织架构
     */
    List<OrganizationInfo> findAll();

    /**
     * 获取当前节点的子节点
     *
     * @param code
     */
    List<OrganizationInfo> findCurrentChild(String code) throws BizException;

    /**
     * 获取当前节点下的所有子节点
     *
     * @param code
     */
    List<OrganizationInfo> findAllChild(String code) throws BizException;
}
