package com.hackathon.hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String teamName;

    @Temporal(TemporalType.DATE)
    private Date teamStartDate;

    @Temporal(TemporalType.DATE)
    private Date teamEndDate;

    private String leadName;

    private String leadEmail;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teams_fk", referencedColumnName = "id")
    private List<Employee> employees;
}
