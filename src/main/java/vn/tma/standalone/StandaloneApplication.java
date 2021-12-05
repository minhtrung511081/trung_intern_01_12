package vn.tma.standalone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.repository.EsRepository;

@SpringBootApplication
/*@ImportResource("classpath:security.xml")*/
public class StandaloneApplication {


    public static void main(String[] args) {
//        SpringApplication.run(StandaloneApplication.class, args);

        ApplicationContext context = SpringApplication.run(StandaloneApplication.class, args);

    }
}
