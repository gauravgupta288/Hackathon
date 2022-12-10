package com.hackathon.hackathon.services;

import com.hackathon.hackathon.dao.EmployeeRepository;
import com.hackathon.hackathon.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees(){
        List<Employee> allEmployees = null;
        try{
            allEmployees = (List<Employee>) employeeRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }

        return allEmployees;
    }
    public Employee getEmployeeById(int id){
        Employee emp = null;
        try{
            emp =  employeeRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return emp;
    }

}
