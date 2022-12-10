package com.hackathon.hackathon.dao;

import com.hackathon.hackathon.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    public Employee findById(int id);
}
