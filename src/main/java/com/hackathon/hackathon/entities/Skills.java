package com.hackathon.hackathon.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "domain")
    private String domain;

    @Column(name = "skill_level")
    private String skill_level;

    @Column(name = "skill")
    private String skills;

    @Column(name = "years_of_experience")
    private int yearsOfExperience;

}
