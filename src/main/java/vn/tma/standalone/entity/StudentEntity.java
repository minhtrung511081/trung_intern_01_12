package vn.tma.standalone.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class StudentEntity extends BaseEntity {
    private String code;
    private String name;
    private Date dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collegeid")
    private CollegeEntity collegeid;

}
