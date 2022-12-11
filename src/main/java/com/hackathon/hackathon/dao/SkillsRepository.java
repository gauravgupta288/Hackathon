package com.hackathon.hackathon.dao;

import com.hackathon.hackathon.entities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface SkillsRepository extends JpaRepository<Skills, Integer> {
}
