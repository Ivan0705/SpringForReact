package spring_react.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_react.demo.exeption.ResourceNotFoundException;
import spring_react.demo.model.Employer;
import spring_react.demo.repository.EmployerRepository;
import spring_react.demo.service.EmployeeService;

import java.util.List;

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

    @PostMapping("/api/v1//employees")
    public boolean createEmployee(@RequestBody Employer employer) {
        return employeeService.addUser(employer);
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
