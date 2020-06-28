package org.link.advertise.organization.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.entity.OrganizationInfo;
import org.link.advertise.core.model.LinkResponse;
import org.link.advertise.organization.service.OrganizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/19 14:45
 */
@RestController
@RequestMapping("/organization")
@Slf4j
@AllArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping("/add")
    public LinkResponse add(@RequestBody OrganizationInfo orgInfo) {
        try {
            organizationService.insert(orgInfo);
        } catch (Exception e) {
            log.error("inser organization error.", e);
            return LinkResponse.FAIL.msg("inser organization error.");
        }
        return LinkResponse.SUCCESS.data(orgInfo);
    }

    @PostMapping("/del")
    public LinkResponse del(@RequestParam("code") String code) {
        try {
            organizationService.delete(code);
        } catch (Exception e) {
            log.error("delete organization error.", e);
            return LinkResponse.FAIL.msg("delete organization error.");
        }
        return LinkResponse.SUCCESS;
    }

    @PostMapping("/getByCode")
    public LinkResponse getByCode(@RequestParam("code") String code) {
        OrganizationInfo organizationInfo = null;
        try {
            organizationInfo = organizationService.getByCode(code);
        } catch (Exception e) {
            log.error("update organization error.", e);
            return LinkResponse.FAIL.msg("inser organization error.");
        }
        return LinkResponse.SUCCESS.data(organizationInfo);
    }

    @PostMapping("/findAll")
    public LinkResponse findAll() {
        List<OrganizationInfo> allList = null;
        try {
            allList = organizationService.findAll();
        } catch (Exception e) {
            log.error("find all organization error.", e);
            return LinkResponse.FAIL.msg("find all organization error.");
        }
        return LinkResponse.SUCCESS.data(allList);
    }

    @PostMapping("/findCurrentChild")
    public LinkResponse findCurrentChild(@RequestParam("code") String code) {
        List<OrganizationInfo> childList = null;
        try {
            childList = organizationService.findCurrentChild(code);
        } catch (Exception e) {
            log.error("find current child organization error.", e);
            return LinkResponse.FAIL.msg("find current child organization error.");
        }
        return LinkResponse.SUCCESS.data(childList);
    }

    @PostMapping("/findAllChild")
    public LinkResponse findAllChild(@RequestParam("code") String code) {
        List<OrganizationInfo> childList = null;
        try {
            childList = organizationService.findAllChild(code);
        } catch (Exception e) {
            log.error("find all child organization error.", e);
            return LinkResponse.FAIL.msg("find all child organization error.");
        }
        return LinkResponse.SUCCESS.data(childList);
    }
}
