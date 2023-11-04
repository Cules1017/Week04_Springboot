package iuh.edu.vn.www_week04_spring.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.edu.vn.www_week04_spring.Reponsitory.SkillRepository;
import iuh.edu.vn.www_week04_spring.entities.Skill;
import iuh.edu.vn.www_week04_spring.services.interfaces.ISkillService;

@Service
public class SkillService implements ISkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.getById(id);
    }
}
