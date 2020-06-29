package org.link.advertise.form.collection.service;

import org.link.advertise.core.dto.PageDTO;
import org.link.advertise.core.entity.FormCollectionInfo;
import org.link.advertise.form.collection.dto.FormCollectionDTO;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/29 10:32
 */
public interface FormCollectionService {
    void add(FormCollectionInfo formCollectionInfo);

    FormCollectionDTO find(PageDTO pageDTO);
}
