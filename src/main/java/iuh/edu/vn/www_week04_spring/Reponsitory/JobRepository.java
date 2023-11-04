package iuh.edu.vn.www_week04_spring.Reponsitory;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.edu.vn.www_week04_spring.entities.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT DISTINCT j FROM Job j " +
           "INNER JOIN j.job_skills js " +
           "WHERE js.skill.id IN :candidateSkillIds")
    List<Job> findJobsByCandidateSkills(@Param("candidateSkillIds") List<Long> candidateSkillIds);
}
