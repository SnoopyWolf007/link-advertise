package org.link.advertise.landingpage.controller;

import com.alibaba.druid.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.entity.LandingPageInfo;
import org.link.advertise.core.model.LinkResponse;
import org.link.advertise.landingpage.dto.LandingPageDTO;
import org.link.advertise.landingpage.dto.PageDTO;
import org.link.advertise.landingpage.service.LandingPageService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 17:38
 */
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/landPage")
public class LandingPageController {

    private final LandingPageService landingPageService;

    @PostMapping("/add")
    public LinkResponse add(@RequestParam("owner") String owner, @RequestBody LandingPageInfo landingPageInfo) {
        String landingPageUrl = landingPageInfo.getLandingPageUrl();
        Long domainId = landingPageInfo.getDomainId();
        if (StringUtils.isEmpty(landingPageUrl)) {
            return LinkResponse.FAIL.msg("landingPageUrl is null or empty.");
        }
        if (Objects.isNull(domainId)) {
            return LinkResponse.FAIL.msg("domainId is null or empty.");
        }

        try {
            landingPageInfo.setCreatorCode(owner);
            landingPageService.add(landingPageInfo);
        } catch (Exception e) {
            log.error("add land page error.", e);
            return LinkResponse.FAIL.msg("add land page error.");
        }
        return LinkResponse.SUCCESS.data(landingPageInfo);
    }

    @PostMapping("/del")
    public LinkResponse del(@RequestParam("id") Long id) {
        try {
            landingPageService.del(id);
        } catch (Exception e) {
            log.error("delete land page error.", e);
            return LinkResponse.FAIL.msg("delete land page error.");
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

        LandingPageDTO landingPageDTO = null;
        try {
            landingPageDTO = landingPageService.find(owner, pageDTO);
        } catch (Exception e) {
            log.error("find land page error.", e);
            return LinkResponse.FAIL.msg("find land page error.");
        }
        return LinkResponse.SUCCESS.data(landingPageDTO);
    }

}
