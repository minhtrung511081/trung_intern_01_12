package vn.tma.standalone.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter(value = AccessLevel.NONE)
    @Column(name = "createdate")
    @CreatedDate
    private Date createDate;

    @Setter(value = AccessLevel.NONE)
    @Column(name = "createby")
    @CreatedBy
    private String createBy;

    @Setter(value = AccessLevel.NONE)
    @Column(name = "modifieddate")
    @LastModifiedDate
    private Date modifiedDate;

    @Setter(value = AccessLevel.NONE)
    @Column(name = "modifiedby")
    @LastModifiedBy
    private String modifiedBy;

}
