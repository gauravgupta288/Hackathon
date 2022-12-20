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

    /**
     * Find project by project id
     * @param id project id to be search
     * @return project object
     */
    public Projects findProjectById(int id){
        return projectRepository.findById(id);
    }
    /**
     * Find project by project name
     * @param projectName name of the project
     * @return project object
     */
    public Projects findProjectByName(String projectName){
        List<Projects> projectsList = projectRepository.findAll();
        if(projectsList == null || projectsList.size() == 0){
            return null;
        }
        Optional<Projects> pro = projectsList.stream().filter(e -> e.getProjectName().equals(projectName)).findFirst();

        //Check if search not found
        if(pro.isEmpty()){
            return null;
        }
        return pro.get();
    }

    public Projects updateProjectByName(int projectId, Projects projects){
        projectRepository.updateProject(projectId, projects.getManagerId(), projects.getProjectStartDate(),
        projects.getProjectEndDate(), projects.getProjectName());

        return findProjectById(projectId);
    }

}
