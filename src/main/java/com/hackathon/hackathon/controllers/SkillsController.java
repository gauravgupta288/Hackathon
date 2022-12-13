package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.dao.EmployeeRepository;
import com.hackathon.hackathon.dao.SkillsRepository;
import com.hackathon.hackathon.entities.Employee;
import com.hackathon.hackathon.entities.Skills;
import com.hackathon.hackathon.services.SkillsServices;
import com.mysql.cj.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.LockModeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.EntityManagerProxy;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SkillsController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    @Autowired
    private SkillsServices skillsServices;

    /**
     * Add new skill with employee data
     *
     * @return Skills object
     */
    @PostMapping("/skills")
    public ResponseEntity<Employee> addSkills(@RequestBody Employee employee){
        try{
            employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/skills")
    public List<Employee> getSkills(){
        return employeeRepository.findAll();
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<Employee> getASkill(@PathVariable("id") int id){
        Employee emp = employeeRepository.findById(id);
        if(emp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

    @DeleteMapping("/skills/{id}/{name}")
    public ResponseEntity<Employee> deleteASkill(@PathVariable int id, @PathVariable String name){
        Skills skill = skillsServices.getSkillIdBySkillName(name, id);
        if(skill == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        skillsRepository.deleteById(skill.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/skills/{id}/{skillName}")
    public ResponseEntity<Employee> updateASkill(@PathVariable int id,@PathVariable String skillName, @RequestBody Skills skillsJson){
        Skills skill = skillsServices.getSkillIdBySkillName(skillName, id);
        if(skill == null){
            skillsRepository.save(skillsJson);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        skillsRepository.updateSkill(skill.getEmp_id(), skill.getId(), skillsJson.getSkill(), skillsJson.getYearsOfExperience(),
                skillsJson.getDomain(), skillsJson.getSkillLevel());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
