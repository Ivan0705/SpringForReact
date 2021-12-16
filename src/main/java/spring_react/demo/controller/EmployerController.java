package spring_react.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring_react.demo.model.Employer;
import spring_react.demo.repository.EmployerRepository;
import spring_react.demo.service.EmployeeService;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployerController {
    private final EmployerRepository employeeRepository;
    private final EmployeeService employeeService;

    @Autowired
    public EmployerController(EmployerRepository employerRepository, EmployeeService employeeService) {
        this.employeeRepository = employerRepository;
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/api/v1//employees")
    public List<Employer> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @PostMapping("/api/v1//employees")
    public boolean createEmployee(@RequestBody Employer employer, BindingResult result) {
        return employeeService.addUser(employer, result);
    }

    @GetMapping("/api/v1//employees/{id}")
    public void getEmployerById(@PathVariable Long id) {
        employeeService.findEmployerById(id);
    }

    @PutMapping("/api/v1//employees/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employer employerDetails) {
        employeeService.update(id, employerDetails);
    }

    @DeleteMapping("/api/v1//employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.remove(id);
    }
}
