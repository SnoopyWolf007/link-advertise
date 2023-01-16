package cn.link.kit.core.base;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

/**
 * @author jcm
 */
public class CommonDao<T extends BaseEntity, QO extends BaseQo<T>> extends SimpleJpaRepository<T, Long> {
    private final EntityManager entityManager;
    private final Class<T> domainClass;

    public CommonDao(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.domainClass = domainClass;
        this.entityManager = em;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected Class<T> getDomainClass() {
        return this.domainClass;
    }
}
