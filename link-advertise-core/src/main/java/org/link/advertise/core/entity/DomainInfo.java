package org.link.advertise.core.entity;

import com.alibaba.druid.util.StringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 17:50
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DomainInfo extends CommonInfo {
    private Long id;
    private String domainUrl;
    private String domainMd5;
    private String owners;

    public List<String> getOwnerList() {
        if (StringUtils.isEmpty(this.owners)) {
            return new ArrayList<>();
        }
        return null;
    }
}
