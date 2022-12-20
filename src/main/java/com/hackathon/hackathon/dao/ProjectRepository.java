package com.hackathon.hackathon.dao;

import com.hackathon.hackathon.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Projects, Integer> {

    public List<Projects> findAll();

    public Projects findById(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Projects SET manager_id = ?2, project_start_date = ?3 ,project_end_date = ?4, project_name = ?5 WHERE id = ?1", nativeQuery = true)
    public void updateProject(int id, int managerId, Date projectStartDate, Date projectEndDate, String projectName);

}
