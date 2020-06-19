package org.link.advertise.organization.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.entity.OrganizationInfo;
import org.link.advertise.core.model.LinkResponse;
import org.link.advertise.organization.dao.OrganizationDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: changmingjiang
 * @Date: 2020/6/19 14:45
 */
@RestController
@RequestMapping("/organization")
@Slf4j
@AllArgsConstructor
public class OrganizationController {

    private final OrganizationDAO organizationDAO;

    @PostMapping("/add")
    public LinkResponse add(@RequestBody OrganizationInfo orgInfo){
        try{
            organizationDAO.add(orgInfo);
        }catch (Exception e){
            LinkResponse.FAIL.msg("inser organization error.");
            log.error("inser organization error.", e);
        }
        return LinkResponse.SUCCESS.data(orgInfo);
    }

    @PostMapping("/del")
    public LinkResponse del(@RequestParam("code") String code){
        try {
            organizationDAO.delete(code);
        }catch (Exception e){
            LinkResponse.FAIL.msg("inser organization error.");
            log.error("delete organization error.", e);
        }
        return LinkResponse.SUCCESS;
    }

    @PostMapping("/findAll")
    public LinkResponse findAll(){
        List<OrganizationInfo> allList = null;
        try {
            allList = organizationDAO.findAll();
        }catch (Exception e){
            LinkResponse.FAIL.msg("inser organization error.");
            log.error("update organization error.", e);
        }
        return LinkResponse.SUCCESS.data(allList);
    }
}
