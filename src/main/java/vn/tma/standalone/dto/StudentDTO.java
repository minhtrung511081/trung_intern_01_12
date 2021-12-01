package vn.tma.standalone.dto;

import java.sql.Date;

public class StudentDTO extends BaseDTO<StudentDTO> {
    private String code;
    private String name;
    private Date dateOfbirth;

    private CollegeDTO collegeid;

    private String codeCollege;


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

    public Date getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(Date dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public CollegeDTO getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(CollegeDTO collegeid) {
        this.collegeid = collegeid;
    }

    public String getCodeCollege() {
        return codeCollege;
    }

    public void setCodeCollege(String codeCollege) {
        this.codeCollege = codeCollege;
    }


}
