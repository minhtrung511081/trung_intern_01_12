package vn.tma.standalone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.ImportResource;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.repository.StudentEsRepository;

import java.util.List;

@SpringBootApplication
/*@ImportResource("classpath:security.xml")*/
public class StandaloneApplication {



    public static StudentEsRepository customerRepository ;

    @Autowired
    public StandaloneApplication(StudentEsRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
//        SpringApplication.run(StandaloneApplication.class, args);

        ApplicationContext context = SpringApplication.run(StandaloneApplication.class, args);


        System.out.println("---------- Demo  insert ----------------");
        Customer customer = new Customer();
        customer.setId("2");
        customer.setName("sena");
        customer.setAddress("ha noi");
        customerRepository.save(customer);
        Customer customer2 = new Customer();
        customer2.setId("1");
        customer2.setName("kai");
        customer2.setAddress("london");
        customerRepository.save(customer2);
        System.out.println("saved!");
    }
}
