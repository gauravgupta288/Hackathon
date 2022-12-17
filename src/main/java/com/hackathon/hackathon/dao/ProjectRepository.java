package com.hackathon.hackathon.dao;

import com.hackathon.hackathon.entities.Projects;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Projects, Integer> {

    public List<Projects> findAll();
}
