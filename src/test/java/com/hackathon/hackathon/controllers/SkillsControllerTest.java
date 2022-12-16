package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.dao.EmployeeRepository;
import com.hackathon.hackathon.entities.Employee;
import com.hackathon.hackathon.entities.Skills;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SkillsControllerTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillsController skillsController;

    @Test
    void addSkills() {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        String fullName = "Gaurav gupta";
        employee.setFullName(fullName);
        String email = "abc@gmail.com";
        employee.setEmail(email);
        employee.setAddress("Pune");
        employee.setMobile(976246398);

        Skills skills = new Skills();
        skills.setId(1);
        skills.setSkillLevel("Basic");
        skills.setDomain("Tech");
        skills.setEmp_id(1);
        skills.setSkill("Java");
        skills.setYearsOfExperience(5);

        employee.setSkills(List.of(skills));
        ResponseEntity<Employee> res = skillsController.addSkills(employee);
        assertEquals(res.getStatusCode().value(), 201);

        Employee employee1 = employeeRepository.findById(1);
        assertEquals( fullName, employee1.getFullName());
        assertEquals( email, employee1.getEmail());
    }

    @Test
    void getSkills() {
    }

    @Test
    void getASkill() {
    }

    @Test
    void deleteASkill() {
    }

    @Test
    void updateASkill() {
    }
}