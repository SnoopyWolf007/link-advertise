package org.link.advertise.form.collection.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.dto.PageDTO;
import org.link.advertise.core.entity.FormCollectionInfo;
import org.link.advertise.core.util.PageUtils;
import org.link.advertise.core.util.UrlUtils;
import org.link.advertise.form.collection.dao.FormCollectionDAO;
import org.link.advertise.form.collection.dto.FormCollectionDTO;
import org.link.advertise.form.collection.service.FormCollectionService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/29 11:46
 */

@Slf4j
@Service
@AllArgsConstructor
public class FormCollectionServiceImpl implements FormCollectionService {

    private final FormCollectionDAO formCollectionDAO;

    @Override
    public void add(FormCollectionInfo formCollectionInfo) {
        if (Objects.isNull(formCollectionInfo)) {
            return;
        }
        String url = formCollectionInfo.getUrl();
        try {
            UrlUtils.UrlDetail analysis = UrlUtils.analysis(url);
            formCollectionInfo.setUrlMd5(analysis.getUrlMd5());
            formCollectionInfo.setChannel(analysis.getChannel());
            formCollectionInfo.setAccount(analysis.getAccount());
            formCollectionInfo.setRemakeUrl(analysis.getRemakeUrl());
            formCollectionInfo.setRemakeUrlMd5(analysis.getRemakeUrlMd5());
        } catch (UnsupportedEncodingException e) {
            log.error("url decode error. url{}", url);
            return;
        }
        formCollectionDAO.insert(formCollectionInfo);
    }

    @Override
    public FormCollectionDTO find(PageDTO pageDTO) {
        if (Objects.isNull(pageDTO) || pageDTO.verifyParam()) {
            return new FormCollectionDTO(pageDTO.getPage(), pageDTO.getPageSize());
        }
        Integer offset = (pageDTO.getPage() - 1) * pageDTO.getPageSize();
        Integer total = formCollectionDAO.count();
        FormCollectionDTO formCollectionDTO = PageUtils.getPageDTO(pageDTO, total, FormCollectionDTO.class);

        formCollectionDTO.setList(formCollectionDAO.find(offset, pageDTO.getPageSize()));
        return formCollectionDTO;
    }
}
