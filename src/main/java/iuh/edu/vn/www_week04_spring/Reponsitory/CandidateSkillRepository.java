package iuh.edu.vn.www_week04_spring.Reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iuh.edu.vn.www_week04_spring.entities.Candidate;
import iuh.edu.vn.www_week04_spring.entities.CandidateSkillId;
import iuh.edu.vn.www_week04_spring.entities.Candidate_Skill;

public interface CandidateSkillRepository extends JpaRepository<Candidate_Skill, CandidateSkillId>{
    
}
