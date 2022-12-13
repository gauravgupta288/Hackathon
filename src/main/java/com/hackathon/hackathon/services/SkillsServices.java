package com.hackathon.hackathon.services;

import com.hackathon.hackathon.dao.SkillsRepository;
import com.hackathon.hackathon.entities.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsServices {

    @Autowired
    private SkillsRepository skillsRepository;
    public Skills getSkillIdBySkillName(String skillName, int empId){
        List<Skills> skillDbData = skillsRepository.findAll();

        Optional<Skills> result = skillDbData.stream().filter(skill ->
                skillName.equals(skill.getSkill()) && empId == skill.getEmp_id()).findFirst();

        if(result.isEmpty()){
            return null;
        }
        return result.get();
    }
}
