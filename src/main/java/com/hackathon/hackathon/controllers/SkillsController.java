package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.dao.SkillsRepository;
import com.hackathon.hackathon.entities.Skills;
import com.hackathon.hackathon.services.SkillsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SkillsController {
    @Autowired
    private SkillsServices skillsServices;
    @Autowired
    private SkillsRepository skillsRepository;

    /**
     * Get all skills
     * @return Skills object
     */
    @GetMapping("/skills")
    public Skills getAllEmployees(){
        return null;
    }


}
