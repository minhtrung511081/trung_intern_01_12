package vn.tma.standalone.service.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import vn.tma.standalone.dto.StudentDTO;
import vn.tma.standalone.entity.StudentEntity;
import vn.tma.standalone.repository.StudentRepository;
import com.github.javafaker.Faker;
import vn.tma.standalone.service.impl.StudentService;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-real.properties"
)
@AutoConfigureMockMvc
public class StudentTestReal {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    private final Faker faker = new Faker();


    @Test
    void canRegisterNewStudent() throws Exception {
        // given
        StudentDTO studentDTO = new StudentDTO(
                "b162",
                "trung ",
                null,
                null,
                "cntt",
                "trung989@gmail.com"
        );

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/api/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)));
        // then
        resultActions.andExpect(status().isOk());
        List<StudentDTO> students = (List<StudentDTO>) studentService.getAll();
        System.out.println(students);
    }
}
