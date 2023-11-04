package iuh.edu.vn.www_week04_spring.services.interfaces;

import java.util.List;

import iuh.edu.vn.www_week04_spring.entities.Candidate;
import iuh.edu.vn.www_week04_spring.entities.Job;
import iuh.edu.vn.www_week04_spring.entities.Job_Skill;

public interface IJobSkillService {
    void createJobSkill(Job_Skill job_skill);
}
