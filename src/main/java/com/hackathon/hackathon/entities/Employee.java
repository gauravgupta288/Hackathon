package com.hackathon.hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee")
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
    private long mobile;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Skills.class)
    @JoinColumn(name = "fk_emp_id", referencedColumnName = "employeeId")
    private List<Skills> skills;

}
