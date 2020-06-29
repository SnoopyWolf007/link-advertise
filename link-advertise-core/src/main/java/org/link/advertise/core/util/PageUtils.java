package org.link.advertise.core.util;

import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.dto.PageDTO;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/29 11:28
 */
@Slf4j
public class PageUtils {
    private PageUtils() {
    }

    public static <T extends PageDTO> T getPageDTO(PageDTO pageDTO, Integer total, Class<T> clazz) {
        T dto = null;
        try {
            dto = clazz.newInstance();
        } catch (InstantiationException e) {
            log.error("{} new instance error.", clazz.getName());
            return null;
        } catch (IllegalAccessException e) {
            log.error("{} new instance illegal error.", clazz.getName());
            return null;
        }
        Integer pageSize = pageDTO.getPageSize();
        Integer totalPage = total / pageSize + (total % pageSize == 0 ? 0 : 1);
        dto.setPage(pageDTO.getPage());
        dto.setPageSize(pageSize);
        dto.setTotal(total);
        dto.setTotalPage(totalPage);
        return dto;
    }
}
