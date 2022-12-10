package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.entities.Employee;
import com.hackathon.hackathon.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;
    @GetMapping("/employees")
    public Employee getAllEmployees(){

        Employee emp = new Employee();
        return emp;
    }
}
