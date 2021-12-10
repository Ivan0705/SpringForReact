package spring_react.demo.ServiceTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import spring_react.demo.model.Employer;
import spring_react.demo.repository.EmployerRepository;
import spring_react.demo.service.EmployeeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    @MockBean
    EmployeeService employeeService;

    @MockBean
    EmployerRepository employerRepository;

    @Test
    public void addEmployee() {
        Employer employer = new Employer();
        BindingResult result = null;
        boolean isEmployerCreated = employeeService.addUser(employer, result);

        Assert.assertTrue(!isEmployerCreated);
        Assert.assertNotNull(employer);

        Mockito.verify(employeeService, Mockito.times(1)).addUser(employer, result);
        Mockito.verify(employerRepository, Mockito.times(0)).save(ArgumentMatchers.any(Employer.class));
    }

    @Test
    public void addEmployeeFailTest() {
        Employer employer = new Employer();
        BindingResult result = null;
        Mockito.doReturn(new Employer())
                .when(employerRepository)
                .save(employer);

        boolean isUserCreated = employeeService.addUser(employer, result);

        Assert.assertFalse(isUserCreated);

        Mockito.verify(employerRepository, Mockito.times(0)).save(ArgumentMatchers.any(Employer.class));
        Mockito.verify(employeeService, Mockito.times(1))
                .addUser(ArgumentMatchers.any(Employer.class), result);
    }
}
