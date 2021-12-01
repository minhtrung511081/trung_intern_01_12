package vn.tma.standalone.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity extends BaseEntity {
    private String code;
    private String name;
    private Date dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collegeid")
    private CollegeEntity collegeid;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CollegeEntity getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(CollegeEntity collegeid) {
        this.collegeid = collegeid;
    }


}
