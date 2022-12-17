package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.dao.EmployeeRepository;
import com.hackathon.hackathon.dao.SkillsRepository;
import com.hackathon.hackathon.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Get a single employee details
     *
     * @param id
     * @return
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getASkill(@PathVariable("id") int id) {
        Employee emp = employeeRepository.findById(id);
        if (emp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

    @PostMapping("/employee")
    public ResponseEntity addEmployee(@RequestBody Employee emp) {
        try {
            employeeRepository.save(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity updateEmployee(@RequestBody Employee emp){
        try{
            Employee employee = employeeRepository.findById(emp.getEmployeeId());
            if(employee == null){
                employeeRepository.save(emp);
            }else{
                employeeRepository.updateEmployeeInfo(emp.getFullName(), emp.getEmail(),
                        emp.getLocation(), emp.getMobile(), emp.getEmployeeId());
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
