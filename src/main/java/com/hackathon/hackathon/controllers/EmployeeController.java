package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.dao.EmployeeRepository;
import com.hackathon.hackathon.dao.SkillsRepository;
import com.hackathon.hackathon.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    @GetMapping("/employee")
    public Employee getAllEmployees(){
        Employee emp = new Employee();
        return emp;
    }

    /**
     * Get a single employee details
     * @param id
     * @return
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getASkill(@PathVariable("id") int id){
        Employee emp = employeeRepository.findById(id);
        if(emp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }
}
