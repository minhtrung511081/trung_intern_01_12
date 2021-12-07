package vn.tma.standalone.dto;

import lombok.Data;

@Data
public class CollegeDTO extends BaseDTO<CollegeDTO> {
    private Long id;
    private String name;
    private String code;

}
