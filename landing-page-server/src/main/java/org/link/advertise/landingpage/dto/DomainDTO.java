package org.link.advertise.landingpage.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.link.advertise.core.entity.DomainInfo;

import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 17:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class DomainDTO extends PageDTO {
    List<DomainInfo> list;

    public DomainDTO(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
}
