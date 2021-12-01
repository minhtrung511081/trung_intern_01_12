package vn.tma.standalone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tma.standalone.entity.CollegeEntity;
import vn.tma.standalone.service.ICollegeService;

@Service
public class CollegeService implements ICollegeService {

    @Override
    public Object getAll() {
        CollegeEntity entity = new CollegeEntity();
        return entity.getStudents();
    }
}
