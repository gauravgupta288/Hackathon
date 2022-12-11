package com.hackathon.hackathon.dao;

import com.hackathon.hackathon.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public Employee findById(int id);
}
