package iuh.edu.vn.www_week04_spring.services.interfaces;

import java.util.List;

import iuh.edu.vn.www_week04_spring.entities.Skill;

public interface ISkillService {
    Skill createSkill(Skill skill);

    List<Skill> getAllSkills();

    Skill getSkillById(Long id);
}
