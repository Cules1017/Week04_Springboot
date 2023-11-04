package iuh.edu.vn.www_week04_spring.Reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.edu.vn.www_week04_spring.entities.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT DISTINCT c FROM Candidate c " +
           "INNER JOIN c.candidate_skills cs " +
           "WHERE cs.skill.id IN (SELECT js.skill.id FROM Job j " +
           "INNER JOIN j.job_skills js WHERE j.id = :jobId)")
    List<Candidate> findCandidatesWithMatchingSkills(@Param("jobId") Long jobId);
}
