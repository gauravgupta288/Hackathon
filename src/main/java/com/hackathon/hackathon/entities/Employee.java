package com.hackathon.hackathon.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "employeeId")
    private int employeeId;

    @Column(name = "email")
    private String email;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "location")
    private String location;

    @Column(name = "mobile")
    private int mobile;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Skills.class)
    @JoinColumn(name = "skills_id", referencedColumnName = "employeeId")
    private List<Skills> skills;

    public Employee(){
        super();
    }
    public Employee(int employeeId, String email, String fullName, String location, List<Skills> skills, int mobile) {
        this.employeeId = employeeId;
        this.email = email;
        this.fullName = fullName;
        this.location = location;
        this.skills = skills;
        this.mobile = mobile;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
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


}
