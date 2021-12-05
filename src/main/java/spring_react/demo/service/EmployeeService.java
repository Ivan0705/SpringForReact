package spring_react.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_react.demo.exeption.ResourceNotFoundException;
import spring_react.demo.model.Employer;
import spring_react.demo.repository.EmployerRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final
    EmployerRepository employerRepository;

    @Autowired
    public EmployeeService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Transactional
    public boolean addUser(Employer employer) {
        if (employer.getFirstName() == null) {
            return false;
        }

        if (employer.getLastName() == null) {
            return false;
        }
        if (employer.getEmailId() == null) {
            return false;
        }

        employerRepository.save(employer);
        return true;
    }

    @Transactional
    public ResponseEntity<Map<String, Boolean>> remove(Long id) {
        Employer employer = employerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));

        employerRepository.delete(employer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity<Employer> update(Long id, Employer employerDetails) {
        Employer employer = employerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));

        employer.setFirstName(employerDetails.getFirstName());
        employer.setLastName(employerDetails.getLastName());
        employer.setEmailId(employerDetails.getEmailId());

        Employer updatedEmployer = employerRepository.save(employer);
        return ResponseEntity.ok(updatedEmployer);
    }

    @Transactional
    public ResponseEntity<Employer> findEmployerById(Long id) {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employer not exits with id: " + id));
        return ResponseEntity.ok(employer);
    }
}
