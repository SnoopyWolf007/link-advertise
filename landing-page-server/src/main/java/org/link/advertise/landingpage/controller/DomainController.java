package org.link.advertise.landingpage.controller;

import com.alibaba.druid.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.entity.DomainInfo;
import org.link.advertise.core.model.LinkResponse;
import org.link.advertise.landingpage.dto.DomainDTO;
import org.link.advertise.landingpage.dto.PageDTO;
import org.link.advertise.landingpage.service.DomainService;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 17:40
 */
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/domain")
public class DomainController {

    private final DomainService domainService;

    @PostMapping("/add")
    public LinkResponse add(@RequestBody DomainInfo domainInfo) {
        String domainUrl = domainInfo.getDomainUrl();
        String owners = domainInfo.getOwners();
        if (StringUtils.isEmpty(domainUrl)) {
            return LinkResponse.FAIL.msg("domainUrl is null or empty.");
        }
        if (StringUtils.isEmpty(owners)) {
            return LinkResponse.FAIL.msg("owners is null or empty.");
        }

        try {
            domainService.add(domainInfo);
        } catch (Exception e) {
            log.error("add domain error.", e);
            return LinkResponse.FAIL.msg("add domain error.");
        }
        return LinkResponse.SUCCESS.data(domainInfo);
    }

    @PostMapping("/del")
    public LinkResponse del(@RequestParam("id") Long id) {
        try {
            domainService.del(id);
        } catch (Exception e) {
            log.error("delete domain error.", e);
            return LinkResponse.FAIL.msg("delete domain error.");
        }
        return LinkResponse.SUCCESS;
    }

    @PostMapping("/find")
    public LinkResponse find(@RequestParam("owner") String owner, @RequestBody PageDTO pageDTO) {
        if (StringUtils.isEmpty(owner)) {
            return LinkResponse.FAIL.msg("owner is null or empty.");
        }
        if (pageDTO.verifyParam()) {
            pageDTO.setPage(1);
            pageDTO.setPageSize(10);
        }

        DomainDTO domainDTO = null;
        try {
            domainDTO = domainService.find(owner, pageDTO);
        } catch (Exception e) {
            log.error("find domain error.", e);
            return LinkResponse.FAIL.msg("delete domain error.");
        }
        return LinkResponse.SUCCESS.data(domainDTO);
    }

}
