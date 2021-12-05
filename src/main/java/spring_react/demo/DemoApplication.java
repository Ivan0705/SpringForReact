package spring_react.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import spring_react.demo.model.Employer;
import spring_react.demo.repository.EmployerRepository;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableMongoRepositories(basePackageClasses = EmployerRepository.class)
public class DemoApplication implements CommandLineRunner {
    @Autowired
    public DemoApplication(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private final
    ApplicationContext context;

    @Override
    public void run(String... args) {
        Employer employer1 = context.getBean(Employer.class);
        employer1.setFirstName("John");
        System.out.println(employer1.getFirstName());
    }
}
