package iuh.edu.vn.www_week04_spring.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import iuh.edu.vn.www_week04_spring.Reponsitory.JobRepository;
import iuh.edu.vn.www_week04_spring.entities.Candidate;
import iuh.edu.vn.www_week04_spring.entities.Job;
import iuh.edu.vn.www_week04_spring.services.interfaces.IJobService;

@Service
public class JobService implements IJobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Page<Job> GetAll(int page, int amount) {
        PageRequest pageRequest = PageRequest.of(page, amount);
        return jobRepository.findAll(pageRequest);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> findJobsWithMatchingSkills(Candidate candidate) {
        List<Long> candidateSkillIds = candidate.getCandidate_skills().stream()
                .map(cs -> cs.getSkill().getId())
                .collect(Collectors.toList());

        return jobRepository.findJobsByCandidateSkills(candidateSkillIds);
    }
}
