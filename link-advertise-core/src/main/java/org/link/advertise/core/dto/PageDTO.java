package org.link.advertise.core.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 17:46
 */
@Data
@NoArgsConstructor
public class PageDTO {

    private Integer page;
    private Integer pageSize;

    private Integer totalPage;
    private Integer total;

    public PageDTO(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public boolean verifyParam() {
        return Objects.isNull(this.page) || Objects.isNull(this.pageSize);
    }
}
