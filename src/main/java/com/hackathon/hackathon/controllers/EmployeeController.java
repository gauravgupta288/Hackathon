package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.entities.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/employees")
    public Employee getAllEmployees(){

        Employee emp = new Employee();
        emp.setEmployeeId(1);
        emp.setEmail("abc@gmail.com");
        emp.setFullName("abc");
        emp.setLocation("Pune");
        return emp;
    }
}
