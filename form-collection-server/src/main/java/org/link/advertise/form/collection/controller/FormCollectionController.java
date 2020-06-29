package org.link.advertise.form.collection.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.dto.PageDTO;
import org.link.advertise.core.entity.FormCollectionInfo;
import org.link.advertise.core.model.LinkResponse;
import org.link.advertise.form.collection.dto.FormCollectionDTO;
import org.link.advertise.form.collection.service.FormCollectionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/29 10:32
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/form")
public class FormCollectionController {

    private final FormCollectionService formCollectionService;

    @PostMapping("/submit")
    public LinkResponse submit(@RequestBody FormCollectionInfo formCollectionInfo) {
        try {
            formCollectionService.add(formCollectionInfo);
        } catch (Exception e) {
            log.error("add form collection error.", e);
            return LinkResponse.FAIL;
        }
        return LinkResponse.SUCCESS;
    }

    @PostMapping("/find")
    public LinkResponse find(@RequestBody PageDTO pageDTO) {
        FormCollectionDTO formCollectionDTO = null;
        if (pageDTO.verifyParam()) {
            pageDTO.setPage(1);
            pageDTO.setPageSize(10);
        }

        try {
            formCollectionDTO = formCollectionService.find(pageDTO);
        } catch (Exception e) {
            log.error("fid form collection error.", e);
            return LinkResponse.FAIL.msg("fid form collection error.");
        }
        return LinkResponse.SUCCESS.data(formCollectionDTO);
    }

}
