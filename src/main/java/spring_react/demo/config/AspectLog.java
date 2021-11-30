package spring_react.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import spring_react.demo.controller.EmployerController;
import spring_react.demo.model.Employer;

@Aspect
@Component
public class AspectLog {
    private static final Logger logger = LoggerFactory.getLogger(EmployerController.class);

    @Before(value = "execution(* spring_react.demo.controller.EmployerController*(..)) && args(employer)")
    public void beforeAdvice(JoinPoint joinPoint, Employer employer) {
        System.out.println("Before method:" + joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* spring_react.demo.controller.EmployerController.getAllEmployees())")
    public void beforeAdviceGetAllEmployees(JoinPoint joinPoint) {
        logger.info("called method getAllEmployees", joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* spring_react.demo.controller.EmployerController.createEmployee())")
    public void beforeAdviceCreateEmployee(JoinPoint joinPoint) {
        logger.info("called method createEmployee", joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* spring_react.demo.controller.EmployerController.getEmployerById())")
    public void beforeAdviceGetEmployerById(JoinPoint joinPoint) {
        logger.info("called method getEmployerById by id", joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* spring_react.demo.controller.EmployerController.updateEmployee())")
    public void beforeAdviceUpdateEmployee(JoinPoint joinPoint) {
        logger.info("called method updateEmployee by id", joinPoint.getSignature().getName());
    }


    @Before(value = "execution(* spring_react.demo.controller.EmployerController.deleteEmployee())")
    public void beforeAdviceDeleteEmployee(JoinPoint joinPoint) {
        logger.info("called method deleteEmployee by id", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* spring_react.demo.controller.EmployerController.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After method:" + joinPoint.getSignature());
    }

    @After(value = "execution(* spring_react.demo.controller.EmployerController.getAllEmployees())")
    public void afterAdviceGetAllEmployees(JoinPoint joinPoint) {
        logger.info("Successfully called method getAllEmployees", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* spring_react.demo.controller.EmployerController.createEmployee())")
    public void afterAdviceCreateEmployee(JoinPoint joinPoint) {
        logger.info("Successfully  created employee with name", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* spring_react.demo.controller.EmployerController.getEmployerById())")
    public void afterAdviceGetEmployerById(JoinPoint joinPoint) {
        logger.info("Successfully called method getEmployerById by id", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* spring_react.demo.controller.EmployerController.updateEmployee())")
    public void afterAdviceUpdateEmployee(JoinPoint joinPoint) {
        logger.info("Successfully updated employee by id", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* spring_react.demo.controller.EmployerController.deleteEmployee())")
    public void afterAdviceDeleteEmployee(JoinPoint joinPoint) {
        logger.info("Successfully  deleted employee by id", joinPoint.getSignature().getName());
    }
}
