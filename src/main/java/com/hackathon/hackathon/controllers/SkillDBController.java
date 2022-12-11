package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.dao.EmployeeRepository;
import com.hackathon.hackathon.dao.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillDBController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillsRepository skillsRepository;
}
