package cn.link.kit.core.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jcm
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public static final int STATUS_DELETE = 0;
    public static final int STATUS_NORMAL = 1;
    @Column(name = "status", columnDefinition = "int(1) DEFAULT NULL COMMENT '删除状态'")
    private Integer status;

    @Column(name = "update_time", columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
    private Date updateTime;

    @Column(name = "create_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
    private Date createTime;
}
