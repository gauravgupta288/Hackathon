package com.hackathon.hackathon.controllers;

import com.hackathon.hackathon.dao.EmployeeRepository;
import com.hackathon.hackathon.dao.SkillsRepository;
import com.hackathon.hackathon.entities.Employee;
import com.hackathon.hackathon.entities.Skills;
import com.hackathon.hackathon.services.SkillsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class SkillsController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    @Autowired
    private SkillsServices skillsServices;

    /**
     * Get all skills with employee details present on Database
     *
     * @return
     */
    @GetMapping("/skills")
    public List<Employee> getSkills() {
        return employeeRepository.findAll();
    }

    /**
     * Add new skill with employee data
     *
     * @return Skills object
     */
    @PostMapping("/skills")
    public ResponseEntity<Employee> addSkills(@RequestBody Employee employee) {
        employee.getSkills().forEach(skill -> {
            Employee emp = employeeRepository.findById(employee.getEmployeeId());
            Skills searchResult = skillsServices.getSkillIdBySkillName(skill.getSkill(), employee.getEmployeeId());
            if (searchResult == null) {
                if(emp == null){
                    employeeRepository.save(employee);
                }else{
                    skillsRepository.save(skill);
                }
            } else {
                updateASkill(searchResult.getEmp_id(), searchResult.getSkill(), skill);
            }
        });
//        try {
//            Skills sk = employee.getSkills().get(0);
//            skillsRepository.save(sk);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Delete a skill based on name
     *
     * @param id   skill id
     * @param name skill name to delete
     * @return
     */
    @DeleteMapping("/skills/{id}/{name}")
    public ResponseEntity<Employee> deleteASkill(@PathVariable int id, @PathVariable String name) {
        Skills skill = skillsServices.getSkillIdBySkillName(name, id);
        if (skill == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        skillsRepository.deleteById(skill.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * Update a skill based on skill name
     *
     * @param empId         employee id
     * @param skillName  skill name
     * @param skillsJson json of skill data to update
     * @return
     */
    @PutMapping("/skills/{id}/{skillName}")
    public ResponseEntity<Employee> updateASkill(@PathVariable int empId, @PathVariable String skillName, @RequestBody Skills skillsJson) {
        Skills skill = skillsServices.getSkillIdBySkillName(skillName, empId);
        if (skill == null) {
            skillsRepository.save(skillsJson);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        skillsRepository.updateSkill(skill.getEmp_id(), skill.getId(), skillsJson.getSkill(), skillsJson.getYearsOfExperience(),
                skillsJson.getDomain(), skillsJson.getSkillLevel());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/skills/{domain}")
    public Set<String> getSkills(@PathVariable String domain){
        return skillsRepository.getAllSkillByDomain(domain);
    }

    @GetMapping("/skills/domain")
    public Set<String> getDomain(){
        return skillsRepository.getAllDomain();
    }
}
