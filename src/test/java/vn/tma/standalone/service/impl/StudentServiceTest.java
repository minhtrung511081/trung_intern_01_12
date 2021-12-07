package vn.tma.standalone.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vn.tma.standalone.converter.StudentCoverter;
import vn.tma.standalone.entity.StudentEntity;
import vn.tma.standalone.exception.BadRequestException;
import vn.tma.standalone.repository.CollegeRepository;
import vn.tma.standalone.repository.StudentRepository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentCoverter studentCoverter;

    @Mock
    private CollegeRepository collegeRepository;

    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StudentService(studentRepository, studentCoverter, collegeRepository);
    }

    @Test
    void canGetAllStudent(){
        underTest.getAll();
        verify(studentRepository).findAll();
    }

    @Test
    void canAddStudent() {
        // given

        StudentEntity studentEntity = new StudentEntity(
                "b16",
                "trung vo",
                null,
                "trung98@gmail.com",
                null
        );

        // when
        underTest.saveTestH2(studentEntity);

        // then
        ArgumentCaptor<StudentEntity> studentArgumentCaptor =
                ArgumentCaptor.forClass(StudentEntity.class);

        verify(studentRepository).save(studentArgumentCaptor.capture());
        StudentEntity capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(studentEntity);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        StudentEntity studentEntity = new StudentEntity(
                "b16",
                "trung vo",
                null,
                "trung98@gmail.com",
                null
        );

        given(studentRepository.selectExistsEmail(anyString()))
                .willReturn(true);

        // when
        // then
        assertThatThrownBy(() -> underTest.saveTestH2(studentEntity))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + studentEntity.getEmail() + " taken");

        verify(studentRepository, never()).save(any());

    }
}