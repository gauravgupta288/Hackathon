package com.hackathon.hackathon.dao;

import com.hackathon.hackathon.entities.Skills;
import org.springframework.data.repository.CrudRepository;

public interface SkillsRepository extends CrudRepository<Skills, Integer> {
}
