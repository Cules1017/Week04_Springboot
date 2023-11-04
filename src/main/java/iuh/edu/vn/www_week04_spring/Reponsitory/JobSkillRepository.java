package iuh.edu.vn.www_week04_spring.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iuh.edu.vn.www_week04_spring.entities.JobSkillId;
import iuh.edu.vn.www_week04_spring.entities.Job_Skill;

@Repository
public interface JobSkillRepository extends JpaRepository<Job_Skill, JobSkillId> {

}
