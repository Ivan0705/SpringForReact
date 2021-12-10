package spring_react.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
@Scope("prototype")
@Component
@Setter
@Getter
@ToString
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    @Size(min = 1, max = 50, message = "Name should be between 1 and 50 characters!")
    @NotEmpty(message = "Name should not be empty")
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 50)
    @NotBlank(message = "Last name should not be empty")
    private String lastName;

    @Column(name = "email_id")
    //@Email(message = "Email should be email!")
    @NotBlank(message = "Email should not be empty!")
    private String emailId;

    public Employer() {
        System.out.println("One employer created ");
    }
}

