package cn.link.kit.org.core.service;

import cn.link.kit.core.base.BaseServiceImpl;
import cn.link.kit.org.core.dao.TenantDao;
import cn.link.kit.org.core.entity.Tenant;
import cn.link.kit.org.core.pojo.qo.TenantQo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author jcm
 */
@Service
@RequiredArgsConstructor
public class TenantService extends BaseServiceImpl<Tenant, TenantDao, TenantQo> {
}
