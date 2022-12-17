package com.hackathon.hackathon.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "employeeId")
    private List<Skills> skills;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "employeeId")
    private List<Status> status;
}
