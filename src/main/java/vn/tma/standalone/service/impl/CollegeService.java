package vn.tma.standalone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tma.standalone.entity.CollegeEntity;
import vn.tma.standalone.entity.QStudentEntity;
import vn.tma.standalone.repository.CollegeRepository;
import vn.tma.standalone.service.ICollegeService;

@Service
public class CollegeService implements ICollegeService {


    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public Object getAll() {
        return collegeRepository.findAll();
    }
}
