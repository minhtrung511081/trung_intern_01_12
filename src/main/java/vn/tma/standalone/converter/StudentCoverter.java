package vn.tma.standalone.converter;

import org.springframework.stereotype.Component;

import vn.tma.standalone.dto.StudentDTO;
import vn.tma.standalone.entity.StudentEntity;

@Component
public class StudentCoverter {


    public StudentDTO toDto(StudentEntity entity) {
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());

        return dto;
    }

    public StudentEntity toEntity(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return entity;
    }

}
