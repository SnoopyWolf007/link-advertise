package org.link.advertise.landingpage.service.impl;

import com.alibaba.druid.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.dto.PageDTO;
import org.link.advertise.core.entity.LandingPageInfo;
import org.link.advertise.core.util.Md5Util;
import org.link.advertise.core.util.PageUtils;
import org.link.advertise.landingpage.dao.LandingPageDAO;
import org.link.advertise.landingpage.dto.LandingPageDTO;
import org.link.advertise.landingpage.service.LandingPageService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 18:21
 */
@Slf4j
@Service
@AllArgsConstructor
public class LandingPageServiceImpl implements LandingPageService {

    private final LandingPageDAO landingPageDAO;

    @Override
    public void add(LandingPageInfo landingPageInfo) {
        if (Objects.isNull(landingPageInfo)) {
            return;
        }
        String landingPageUrl = landingPageInfo.getLandingPageUrl();
        String md5 = Md5Util.md5(landingPageUrl);
        landingPageInfo.setLandingPageMd5(md5);

        String[] split = landingPageUrl.split("\\?");
        if (split.length == 2) {
            landingPageInfo.setLandingPageParams(split[1]);
        }
        landingPageDAO.insert(landingPageInfo);
    }

    @Override
    public void del(Long id) {
        if (Objects.isNull(id)) {
            return;
        }
        landingPageDAO.delete(id);
    }

    @Override
    public LandingPageDTO find(String owner, PageDTO pageDTO) {
        if (StringUtils.isEmpty(owner) || Objects.isNull(pageDTO)
                || pageDTO.verifyParam()) {
            return new LandingPageDTO(pageDTO.getPage(), pageDTO.getPageSize());
        }
        Integer offset = (pageDTO.getPage() - 1) * pageDTO.getPageSize();
        Integer total = landingPageDAO.count(owner);

        LandingPageDTO landingPageDTO = PageUtils.getPageDTO(pageDTO, total, LandingPageDTO.class);
        if (Objects.isNull(landingPageDTO)) {
            return null;
        }

        landingPageDTO.setList(landingPageDAO.find(owner, offset, pageDTO.getPageSize()));
        return landingPageDTO;
    }
}
