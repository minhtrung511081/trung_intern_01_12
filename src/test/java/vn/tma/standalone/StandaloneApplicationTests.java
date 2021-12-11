package vn.tma.standalone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-real.properties"
)
class StandaloneApplicationTests {



}
