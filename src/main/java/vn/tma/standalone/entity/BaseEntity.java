package vn.tma.standalone.entity;

import lombok.Data;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdate")
    private Date createDate;

    @Column(name = "createby")
    private String createBy;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    @Column(name = "modifiedby")
    private String modifiedBy;

}
