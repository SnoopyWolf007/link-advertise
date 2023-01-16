package cn.link.kit.org.core.entity;

import cn.link.kit.core.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * @author jcm
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "sys_user")
public class User extends BaseEntity {

    @Column(name = "username", columnDefinition = "varchar(128) DEFAULT NULL COMMENT '账号'")
    private String username;

    @Column(name = "password", columnDefinition = "varchar(128) DEFAULT NULL COMMENT '密码'")
    private String password;

    @Column(name = "mobile", columnDefinition = "varchar(32) DEFAULT NULL COMMENT '手机'")
    private String mobile;

    @Column(name = "email", columnDefinition = "varchar(64) DEFAULT NULL COMMENT '邮箱'")
    private String email;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    private Set<Role> userRoles;

    @ManyToOne(targetEntity = Department.class, fetch = FetchType.EAGER)
    private Department department;
}
