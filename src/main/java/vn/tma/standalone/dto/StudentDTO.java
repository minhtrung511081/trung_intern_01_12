package vn.tma.standalone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends BaseDTO<StudentDTO> {
    private String code;
    private String name;
    private Date dateOfbirth;

    private CollegeDTO collegeid;

    private String codeCollege;

    private String email;

}
