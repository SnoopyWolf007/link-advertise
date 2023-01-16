package cn.link.kit.org.core.service;

import cn.link.kit.core.base.BaseServiceImpl;
import cn.link.kit.org.core.dao.DepartmentDao;
import cn.link.kit.org.core.entity.Department;
import cn.link.kit.org.core.pojo.qo.DepartmentQo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author jcm
 */
@Service
@RequiredArgsConstructor
public class DepartmentService extends BaseServiceImpl<Department, DepartmentDao, DepartmentQo> {
}
