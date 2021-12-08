package vn.tma.standalone.entity;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class StudentEntity extends BaseEntity  implements Serializable {
    private String code;
    private String name;
    private Date dateOfBirth;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collegeid")
    private CollegeEntity collegeid;

}
