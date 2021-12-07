package vn.tma.standalone.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vn.tma.standalone.entity.StudentEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void itShouldCheckWhenStudentEmailExists(){
        StudentEntity studentEntity = new StudentEntity("b1610", "trung",null,"trung98@gmail.com",null);
        studentRepository.save(studentEntity);
        boolean expected = studentRepository.selectExistsEmail("trung98@gmail.com");
        assertThat(expected).isTrue();
    }

    @Test
    public void itShouldCheckWhenStudentEmailDoesNotExists(){
        String email = "trung98@gmail.com";
        boolean expected = studentRepository.selectExistsEmail(email);
        assertThat(expected).isFalse();
    }



}