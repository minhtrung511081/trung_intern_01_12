package vn.tma.standalone.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "college")
@Data
public class CollegeEntity extends BaseEntity {
    private String code;
    private String name;

    @OneToMany(mappedBy = "collegeid")
    private List<StudentEntity> students = new ArrayList<>();

}
