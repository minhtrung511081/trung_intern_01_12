package vn.tma.standalone.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "college")
@Data
public class CollegeEntity extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "collegeid", fetch = FetchType.LAZY)
    private List<StudentEntity> students = new ArrayList<>();

}
