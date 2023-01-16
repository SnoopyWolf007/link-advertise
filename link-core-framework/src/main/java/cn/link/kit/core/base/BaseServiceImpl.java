package cn.link.kit.core.base;

import cn.link.kit.core.util.IBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jcm
 */
public class BaseServiceImpl<T extends BaseEntity, Dao extends BaseDao<T>, QO extends BaseQo<T>> implements BaseService<T, Dao, QO> {

    @Resource
    private BaseDao<T> dao;

    @Override
    @Transactional(readOnly = true)
    public T get(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id不能为空");
        }
        return dao.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> page(QO qo, Pageable pageable) {
        return dao.findAll(qo, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll(QO qo) {
        return dao.findAll(qo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T add(T t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        t.setStatus(BaseEntity.STATUS_NORMAL);
        return dao.save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addBatch(List<T> list) {
        List<T> ts = dao.saveAll(list);
        return ts.size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T updateById(T t) {
        if (t == null) {
            throw new IllegalArgumentException("更新对象不能为空");
        }
        // old
        if (t.getId() == null) {
            throw new IllegalArgumentException("id不能为空");
        }
        T old = dao.getById(t.getId());
        IBeanUtils.update(old, t);
        old.setUpdateTime(new Date());
        return dao.save(old);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByIdBatch(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        List<Long> ids = new ArrayList<>(list.size());
        for (T t : list) {
            if (t.getId() == null) {
                throw new IllegalArgumentException("id不能为空");
            }
            ids.add(t.getId());
        }
        List<T> olds = dao.findAllById(ids);
        Map<Long, T> oldMap = olds.stream().collect(Collectors.toMap(BaseEntity::getId, x -> x, (x, y) -> x));

        List<T> batchList = new ArrayList<>(list.size());
        for (T t : list) {
            T old = oldMap.get(t.getId());
            if (old == null) {
                throw new IllegalArgumentException("数据不存在");
            }
            IBeanUtils.update(old, t);
            old.setUpdateTime(new Date());
            batchList.add(old);
        }
        List<T> ts = dao.saveAll(batchList);
        return ts.size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(QO qo) {
        List<T> list = findAll(qo);
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        List<Long> ids = list.stream().map(BaseEntity::getId).collect(Collectors.toList());
        dao.deleteAllById(ids);
        return list.size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id) {
        if (id == null) {
            return 0;
        }
        dao.deleteById(id);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByIdBatch(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        dao.deleteAllById(ids);
        return ids.size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteStatus(QO qo) {
        List<T> list = findAll(qo);
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        for (T t : list) {
            t.setStatus(BaseEntity.STATUS_DELETE);
            t.setUpdateTime(new Date());
        }
        List<T> ts = dao.saveAll(list);
        return ts.size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteStatusById(Long id) {
        if (id == null) {
            return 0;
        }
        T t = get(id);
        if (t == null) {
            return 0;
        }
        t.setStatus(BaseEntity.STATUS_DELETE);
        t.setUpdateTime(new Date());
        dao.save(t);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteStatusByIdBatch(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        List<T> list = dao.findAllById(ids);
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        for (T t : list) {
            t.setStatus(BaseEntity.STATUS_DELETE);
            t.setUpdateTime(new Date());
        }
        List<T> ts = dao.saveAll(list);
        return ts.size();
    }
}
