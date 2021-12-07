package vn.tma.standalone.converter;

import org.springframework.stereotype.Component;
import vn.tma.standalone.dto.CollegeDTO;
import vn.tma.standalone.entity.CollegeEntity;

@Component
public class CollegeConverter {
    public CollegeDTO toDto(CollegeEntity collegeEntity){
        CollegeDTO collegeDTO = new CollegeDTO();
        collegeDTO.setId(collegeEntity.getId());
        collegeDTO.setCode(collegeEntity.getCode());
        collegeDTO.setName(collegeEntity.getName());
        return collegeDTO;
    }

    public CollegeEntity toEntity(CollegeDTO collegeDTO){
        CollegeEntity collegeEntity = new CollegeEntity();
        collegeEntity.setId(collegeDTO.getId());
        collegeEntity.setCode(collegeDTO.getCode());
        collegeEntity.setName(collegeDTO.getName());
        return collegeEntity;
    }

}
