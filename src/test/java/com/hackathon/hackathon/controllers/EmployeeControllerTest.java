package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.entities.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeControllerTest {

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private SkillsController skillsController;

    @Test
    void getAllEmployees() {
        Employee emp = new Employee();
        emp.setEmployeeId(000);
        emp.setEmail("dummy@mail.com");
        emp.setLocation("Pune");
        emp.setFullName("hackathon client");
        emp.setMobile(1234);

        employeeController.addEmployee(emp);
        List<Employee> employees = employeeController.getAllEmployees();

//        employees.forEach(e -> {
//            e.getEmployeeId() == emp.getEmployeeId();
//        });
    }

    @Test
    void getASkill() {
    }

    @Test
    void addEmployee() {
    }

    @Test
    void updateEmployee() {
    }
}