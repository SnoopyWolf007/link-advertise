package org.link.advertise.landingpage.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.link.advertise.core.entity.LandingPageInfo;

import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 17:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class LandingPageDTO extends PageDTO {
    List<LandingPageInfo> list;

    public LandingPageDTO(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
}
