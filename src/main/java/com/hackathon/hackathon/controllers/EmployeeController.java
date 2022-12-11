package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.dao.EmployeeRepository;
import com.hackathon.hackathon.dao.SkillsRepository;
import com.hackathon.hackathon.dto.SkillRequest;
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
     * Add new skill with employee data
     *
     * @return Skills object
     */
//    @PostMapping("/employee")
//    public ResponseEntity<Employee> addSkills(@RequestBody SkillRequest request){
//        try{
//            employeeRepository.save(request.getEmployee());
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
}
