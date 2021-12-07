package vn.tma.standalone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import vn.tma.standalone.entity.StudentEntity;
import vn.tma.standalone.service.impl.StudentService;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class StandaloneApplicationTests {

    @Test
    void itShouldAddTwoNumbers(){
        //given
        int numberOne = 10;
        int numberTwo = 20;
        //when
        int result = new Calculator().add(numberOne,numberTwo);

        //then
        int Expected=30;
        assertThat(result).isEqualTo(Expected);
    }

    class Calculator{
        int add(int a, int b){
            return a+b;
        }
    }

}
