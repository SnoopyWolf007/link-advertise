package cn.link.kit.core.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author jcm
 */
public interface BaseService<T extends BaseEntity, Dao extends BaseDao<T>, QO extends BaseQo<T>> {
    /**
     * get
     *
     * @param id 主键
     * @return T
     */
    T get(Long id);

    /**
     * page
     *
     * @param qo       查询条件
     * @param pageable 分页条件，页码和排序
     * @return T
     */
    Page<T> page(QO qo, Pageable pageable);

    /**
     * findAll
     *
     * @return List<T>
     */
    List<T> findAll();

    /**
     * findAll
     *
     * @param qo 查询条件
     * @return List<T>
     */
    List<T> findAll(QO qo);

    /**
     * add
     *
     * @param t 实体
     * @return List<T>
     */
    T add(T t);

    /**
     * addBatch
     *
     * @param list 实体集合
     * @return int
     */
    int addBatch(List<T> list);

    /**
     * updateById
     *
     * @param t 实体
     * @return List<T>
     */
    T updateById(T t);

    /**
     * updateByIdBatch
     *
     * @param list 实体集合
     * @return int
     */
    int updateByIdBatch(List<T> list);

    /**
     * 物理删除
     *
     * @param qo 查询条件
     * @return int
     */
    int delete(QO qo);

    /**
     * 物理删除
     *
     * @param id 主键
     * @return int
     */
    int deleteById(Long id);

    /**
     * 物理删除（批量）
     *
     * @param ids 主键集合
     * @return int
     */
    int deleteByIdBatch(List<Long> ids);

    /**
     * 物理删除
     *
     * @param qo 查询条件
     * @return int
     */
    int deleteStatus(QO qo);

    /**
     * 逻辑删除
     *
     * @param id 主键
     * @return int
     */
    int deleteStatusById(Long id);

    /**
     * 逻辑删除（批量）
     *
     * @param ids 主键集合
     * @return int
     */
    int deleteStatusByIdBatch(List<Long> ids);

}
