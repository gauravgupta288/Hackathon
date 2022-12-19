package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.dao.ProjectRepository;
import com.hackathon.hackathon.entities.Employee;
import com.hackathon.hackathon.entities.Projects;
import com.hackathon.hackathon.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectServices projectServices;

    @PostMapping("/project")
    public ResponseEntity addProjects(@RequestBody Projects projects) {
        try {
            Projects res = projectServices.findProjectByName(projects.getProjectName());
            if(res == null){
                projectRepository.save(projects);
            }else{
                updateProject(projects);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/project")
    public List<Projects> getProjects() {
        List<Projects> projects = new ArrayList<>();
        try {
            ResponseEntity.status(HttpStatus.OK).build();
            projects = projectRepository.findAll();
            return projects;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return projects;
    }

    @PutMapping("/project")
    public List<Projects> updateProject(@RequestBody Projects project) {
        List<Projects> pro = new ArrayList<>();
        try {
            ResponseEntity.status(HttpStatus.OK).build();
            pro = projectRepository.findAll();
            return pro;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return pro;
    }

}
