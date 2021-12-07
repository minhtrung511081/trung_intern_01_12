package vn.tma.standalone.entity;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor @NoArgsConstructor
public class StudentEntity extends BaseEntity {
    private String code;
    private String name;
    private Date dateOfBirth;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collegeid")
    private CollegeEntity collegeid;

}
