package cn.link.kit.core.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author jcm
 */
public class BaseController<T extends BaseEntity, Dao extends BaseDao<T>, QO extends BaseQo<T>> {

    @Resource
    private BaseService<T, Dao, QO> service;

    @GetMapping("/{id}")
    public T get(@PathVariable(name = "id") Long id) {
        return service.get(id);
    }

    @PostMapping
    public T add(@RequestBody T t) {
        return service.add(t);
    }

    @PutMapping
    public T update(@RequestBody T t) {
        return service.updateById(t);
    }

    @DeleteMapping
    public int del(Long id) {
        return service.deleteStatusById(id);
    }

    @GetMapping
    public Page<T> page(QO qo, Pageable pageable) {
        return service.page(qo, pageable);
    }
}
