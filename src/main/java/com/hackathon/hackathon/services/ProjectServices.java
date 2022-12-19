package com.hackathon.hackathon.services;

import com.hackathon.hackathon.dao.ProjectRepository;
import com.hackathon.hackathon.entities.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;

    public Projects findProjectByName(String projectName){
        List<Projects> projectsList = projectRepository.findAll();
        if(projectsList == null || projectsList.size() == 0){
            return null;
        }

        Optional<Projects> pro = projectsList.stream().filter(e -> e.getProjectName().equals(projectName)).findFirst();
        return pro.get();
    }

    public Projects updateProjectByName(String projectName){
        Projects project = findProjectByName(projectName);

//        Optional<Projects> pro = projectsList.stream().filter(e -> e.getProjectName().equals(projectName)).findFirst();
        return null;
    }

}
