package com.hackathon.hackathon.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "emp_id")
    private int employeeId;

    @Column(name = "emp_email")
    private String email;

    @Column(name = "emp_fullname")
    private String fullName;

    @Column(name = "emp_loaction")
    private String location;

    @Column(name = "emp_skills")
    private Skills skills;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee(){
        super();
    }
    public Employee(int employeeId, String email, String fullName, String location) {
        this.employeeId = employeeId;
        this.email = email;
        this.fullName = fullName;
        this.location = location;
    }
}
