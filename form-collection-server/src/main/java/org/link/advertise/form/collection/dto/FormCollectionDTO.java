package org.link.advertise.form.collection.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.link.advertise.core.dto.PageDTO;
import org.link.advertise.core.entity.FormCollectionInfo;

import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/29 11:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class FormCollectionDTO extends PageDTO {
    private List<FormCollectionInfo> list;

    public FormCollectionDTO(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
}
