package vn.tma.standalone.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "college")
@ToString(exclude = "students")
@Getter @Setter
public class CollegeEntity extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "collegeid")
    private List<StudentEntity> students = new ArrayList<>();

}
