package com.hackathon.hackathon.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "Skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "skills")
    private String skills;

    @Column(name = "domain")
    private String domain;

    @Column(name = "skill_level")
    private String skill_level;

    @Column(name = "years_of_experience")
    private int yearsOfExperience;

    public Skills() {
        super();
    }

    public Skills(int id, String skills, String domain, String skill_level, int yearsOfExperience) {
        this.id = id;
        this.skills = skills;
        this.domain = domain;
        this.skill_level = skill_level;
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSkill_level() {
        return skill_level;
    }

    public void setSkill_level(String skill_level) {
        this.skill_level = skill_level;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

}
