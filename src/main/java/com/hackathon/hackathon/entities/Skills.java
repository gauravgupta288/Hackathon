package com.hackathon.hackathon.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Skills")
public class Skills {

    @Id
    @Column(name = "skill_id")
    private int skill_id;

    @Column(name = "skills")
    private String skills;

    @Column(name = "domain")
    private String domain;

    @Column(name = "skill_level")
    private String skill_level;

    @Column(name = "yearsOfExperience")
    private int yearsOfExperience;

    public Skills() {
        super();
    }

    public Skills(int skill_id, String skills, String domain, String skill_level, int yearsOfExperience, int employeeId) {
        this.skill_id = skill_id;
        this.skills = skills;
        this.domain = domain;
        this.skill_level = skill_level;
        this.yearsOfExperience = yearsOfExperience;
        this.employeeId = employeeId;
    }

    @Column(name = "emp_id")
    private int employeeId;

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
