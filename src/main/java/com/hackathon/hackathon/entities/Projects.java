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
@Table(name = "projects")
public class Projects {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String projectName;

    @Temporal(TemporalType.DATE)
    private Date projectStartDate;

    @Temporal(TemporalType.DATE)
    private Date projectEndDate;

    private String managerName;

    private  String managerEmail;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projects_fk", referencedColumnName = "id")
    private List<Teams> teams;
}
