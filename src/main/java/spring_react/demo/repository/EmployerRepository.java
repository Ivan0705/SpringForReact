package spring_react.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_react.demo.model.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
 //   Employer findByUsername(String firstName);
}
