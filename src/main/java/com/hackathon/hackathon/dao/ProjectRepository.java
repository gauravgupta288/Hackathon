package com.hackathon.hackathon.dao;

import com.hackathon.hackathon.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Projects, Integer> {

    public List<Projects> findAll();

    @Modifying
    @Transactional
    @Query(value = "UPDATE Projects SET manager_ = ?3, years_of_experience = ?4 ,domain = ?5, skill_level = ?6 WHERE emp_id = ?1 and id = ?2", nativeQuery = true)
    public void updateProject(int id, int skillId, String skillName, int yoe, String domain, String skillLevel);

}
