package spring_react.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_react.demo.exeption.ResourceNotFoundException;
import spring_react.demo.model.Employer;
import spring_react.demo.repository.EmployerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class EmployerController {
    private final EmployerRepository employeeRepository;

    @Autowired
    public EmployerController(EmployerRepository employerRepository) {
        this.employeeRepository = employerRepository;
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
    public Employer createEmployee(@RequestBody Employer employer) {
        return employeeRepository.save(employer);
    }

    @GetMapping("/api/v1//employees/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable Long id) {
        Employer employer = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employer not exits with id: " + id));
        return ResponseEntity.ok(employer);
    }

    @PutMapping("/api/v1//employees/{id}")
    public ResponseEntity<Employer> updateEmployee(@PathVariable Long id, @RequestBody Employer employerDetails) {
        Employer employer = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));

        employer.setFirstName(employerDetails.getFirstName());
        employer.setLastName(employerDetails.getLastName());
        employer.setEmailId(employerDetails.getEmailId());

        Employer updatedEmployer = employeeRepository.save(employer);
        return ResponseEntity.ok(updatedEmployer);
    }

    @DeleteMapping("/api/v1//employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employer employer = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));

        employeeRepository.delete(employer);
        Map<String, Boolean> respomse = new HashMap<>();
        respomse.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(respomse);
    }
}
