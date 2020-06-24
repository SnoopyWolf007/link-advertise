package org.link.advertise.organization.service;

import org.link.advertise.core.entity.PersonnelInfo;
import org.link.advertise.core.exception.BizException;

import java.util.List;

/**
 * @Author: changmingjiang
 * @Date: 2020/6/19 15:01
 */
public interface PersonnelService {
    /**
     * 插入
     *
     * @param personnelInfo
     */
    void insert(PersonnelInfo personnelInfo) throws BizException;

    /**
     * 更新
     *
     * @param personnelInfo
     */
    void update(PersonnelInfo personnelInfo) throws BizException;

    /**
     * 删除
     *
     * @param code
     */
    void delete(String code) throws BizException;

    /**
     * 通过code查找
     *
     * @param code
     */
    PersonnelInfo getByCode(String code) throws BizException;

    /**
     * 查找所有
     */
    List<PersonnelInfo> findAll() throws BizException;

    /**
     * 通过组织架构code查询当前组织架构下的人员信息
     *
     * @param organizationCode
     */
    List<PersonnelInfo> findCurrentChild(String organizationCode) throws BizException;

    /**
     * 通过组织架构code查询当前组织架构下的所有节点人员
     *
     * @param organizationCode
     */
    List<PersonnelInfo> findAllChild(String organizationCode) throws BizException;
}
