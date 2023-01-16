package cn.link.kit.org.controller;

import cn.link.kit.core.base.BaseController;
import cn.link.kit.org.core.dao.TenantDao;
import cn.link.kit.org.core.entity.Tenant;
import cn.link.kit.org.core.pojo.qo.TenantQo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jcm
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/tenant")
public class TenantController extends BaseController<Tenant, TenantDao, TenantQo> {
}
