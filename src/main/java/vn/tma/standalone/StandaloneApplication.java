package vn.tma.standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class StandaloneApplication {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StandaloneApplication.class, args);

    }
}
