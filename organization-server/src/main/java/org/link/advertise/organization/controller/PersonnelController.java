package org.link.advertise.organization.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.entity.PersonnelInfo;
import org.link.advertise.core.model.LinkResponse;
import org.link.advertise.organization.service.PersonnelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/19 14:57
 */
@RestController
@RequestMapping("/personnel")
@Slf4j
@AllArgsConstructor
public class PersonnelController {

    private final PersonnelService personnelService;

    @PostMapping("/add")
    public LinkResponse add(@RequestBody PersonnelInfo personnelInfo) {
        try {
            personnelService.insert(personnelInfo);
        } catch (Exception e) {
            log.error("inser personnel error.", e);
            return LinkResponse.FAIL.msg("inser personnel error.");
        }
        return LinkResponse.SUCCESS;
    }

    @PostMapping("/del")
    public LinkResponse del(@RequestParam("code") String code) {
        try {
            personnelService.delete(code);
        } catch (Exception e) {
            log.error("delete personnel error.", e);
            return LinkResponse.FAIL.msg("delete personnel error.");
        }
        return LinkResponse.SUCCESS;
    }

    @PostMapping("/findAll")
    public LinkResponse findAll() {
        List<PersonnelInfo> allList = null;
        try {
            allList = personnelService.findAll();
        } catch (Exception e) {
            log.error("find all personnel error.", e);
            return LinkResponse.FAIL.msg("find all personnel error.");
        }
        return LinkResponse.SUCCESS.data(allList);
    }

    @PostMapping("/findCurrentChild")
    public LinkResponse findCurrentChild(@RequestParam("code") String code) {
        List<PersonnelInfo> currentChildList = null;
        try {
            currentChildList = personnelService.findCurrentChild(code);
        } catch (Exception e) {
            log.error("inser personnel error.", e);
            return LinkResponse.FAIL.msg("inser personnel error.");
        }
        return LinkResponse.SUCCESS.data(currentChildList);
    }

    @PostMapping("/findAllChild")
    public LinkResponse findAllChild(@RequestParam("code") String code) {
        List<PersonnelInfo> allChildPersonnelList = null;
        try {
            allChildPersonnelList = personnelService.findAllChild(code);
        } catch (Exception e) {
            log.error("find all child personnel error.", e);
            return LinkResponse.FAIL.msg("find all child personnel error.");
        }
        return LinkResponse.SUCCESS.data(allChildPersonnelList);
    }
}
