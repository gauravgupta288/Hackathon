package com.hackathon.hackathon.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String domain;

    @Column(name = "skill_level")
    private String skillLevel;

    private String skill;

    @Column(name = "years_of_experience")
    private int yearsOfExperience;

    private int emp_id;

    public void Skills(int emp_id){
        this.emp_id = emp_id;
    }

}
