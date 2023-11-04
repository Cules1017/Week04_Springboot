package iuh.edu.vn.www_week04_spring.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.edu.vn.www_week04_spring.Reponsitory.JobSkillRepository;
import iuh.edu.vn.www_week04_spring.entities.Job_Skill;
import iuh.edu.vn.www_week04_spring.services.interfaces.IJobSkillService;

@Service
public class JobSkillService implements IJobSkillService {

    @Autowired
    private JobSkillRepository jobSkillRepository;

    public void createJobSkill(Job_Skill job_skill) {
        jobSkillRepository.save(job_skill);
    }
}
