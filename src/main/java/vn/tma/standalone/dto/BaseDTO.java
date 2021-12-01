package vn.tma.standalone.dto;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class BaseDTO<T> {
    private Long id;

    private Date createDate;

    private String createBy;

    private Date modifiedDate;

    private String modifiedBy;

    List<T> listResult = new ArrayList<>();

}
