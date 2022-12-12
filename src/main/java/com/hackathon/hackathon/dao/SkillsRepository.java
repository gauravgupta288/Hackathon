package com.hackathon.hackathon.dao;

import com.hackathon.hackathon.entities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface SkillsRepository extends JpaRepository<Skills, Integer> {

    @Query("UPDATE skills SET skill = : sn WHERE id = : id")
    public Skills getUserSkill(@Param("id") int id, @Param("sn") String skillName);
}
