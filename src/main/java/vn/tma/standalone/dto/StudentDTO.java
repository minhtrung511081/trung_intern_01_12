package vn.tma.standalone.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class StudentDTO extends BaseDTO<StudentDTO> {
    private String code;
    private String name;
    private Date dateOfbirth;

    private CollegeDTO collegeid;

    private String codeCollege;

}
