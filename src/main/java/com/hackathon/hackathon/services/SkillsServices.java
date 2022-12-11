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
    public Optional<Skills> getSkillIdBySkillName(String name, int id){
        List<Skills> skillDbData = skillsRepository.findAll();

        Optional<Skills> result = skillDbData.stream().filter(skill ->
                name.equals(skill.getSkill()) && id == skill.getEmp_id()).findAny();

        return result;
    }
}
