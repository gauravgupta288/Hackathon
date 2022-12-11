package com.hackathon.hackathon.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackathon.hackathon.dao.EmployeeRepository;
import com.hackathon.hackathon.entities.Employee;
import com.hackathon.hackathon.entities.Skills;
import com.hackathon.hackathon.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @Autowired
    private EmployeeRepository employeeRepository;

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
    //@PostMapping("/employee")
    @RequestMapping(value = {"/employee"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Employee> addNewSkill(@RequestBody List<Employee> employees){
        try{
            System.out.println("method called");
            for(Employee emp :  employees){
                employeeRepository.save(emp);
                //employeeRepository.saveAll(employees);
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
