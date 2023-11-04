package iuh.edu.vn.www_week04_spring.services.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import iuh.edu.vn.www_week04_spring.entities.Candidate;
import iuh.edu.vn.www_week04_spring.entities.Job;

public interface IJobService {
    Page<Job> GetAll(int page, int amount);

    Job getJobById(Long id);
    
    Job createJob(Job job);

    List<Job> findJobsWithMatchingSkills(Candidate candidate);
}
