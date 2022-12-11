package com.hackathon.hackathon.dto;

import com.hackathon.hackathon.entities.Employee;
import com.hackathon.hackathon.entities.Skills;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SkillRequest {
    private Employee employee;

    private Skills skills;
}
