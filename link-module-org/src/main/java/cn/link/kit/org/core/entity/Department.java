package cn.link.kit.org.core.entity;

import cn.link.kit.core.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jcm
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "sys_department")
public class Department extends BaseEntity {

    @Column(name = "code", columnDefinition = "varchar(128) DEFAULT NULL COMMENT '编码'")
    private String code;

    @Column(name = "name", columnDefinition = "varchar(128) DEFAULT NULL COMMENT '名称'")
    private String name;

    @Column(name = "pid", columnDefinition = "bigint(20) DEFAULT NULL COMMENT '父节点'")
    private Long pid;

    @Column(name = "level", columnDefinition = "int(11) DEFAULT NULL COMMENT '级别'")
    private Integer level;

}
