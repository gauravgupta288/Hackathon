package com.hackathon.hackathon.services;

import com.hackathon.hackathon.dao.EmployeeRepository;
import com.hackathon.hackathon.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee emp){
        return employeeRepository.save(emp);
    }
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
