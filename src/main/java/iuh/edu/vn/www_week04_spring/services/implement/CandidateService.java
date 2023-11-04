package iuh.edu.vn.www_week04_spring.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import iuh.edu.vn.www_week04_spring.Reponsitory.CandidateRepository;
import iuh.edu.vn.www_week04_spring.common.Pagination;
import iuh.edu.vn.www_week04_spring.entities.Candidate;
import iuh.edu.vn.www_week04_spring.entities.Company;
import iuh.edu.vn.www_week04_spring.entities.Job;
import iuh.edu.vn.www_week04_spring.services.interfaces.ICandidateService;

@Service
public class CandidateService implements ICandidateService {
    
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Pagination<Candidate> getAllCandidates(int page, int amount, String nameFilter, List<Long> skillFilter) {
        List<Candidate> allCandidates = candidateRepository.findAll();
        if (nameFilter != null) {
            allCandidates = allCandidates.stream()
                    .filter(candidate -> candidate.getFull_name().toLowerCase().contains(nameFilter.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (skillFilter != null && !skillFilter.isEmpty()) {
            allCandidates = allCandidates.stream()
                    .filter(candidate -> candidate.getCandidate_skills()
                            .stream()
                            .anyMatch(candidateSkill -> skillFilter.contains(candidateSkill.getSkill().getId())))
                    .collect(Collectors.toList());
        }
        return new Pagination<Candidate>(allCandidates, page, amount);
    }
    
    public Candidate getById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    public Pagination<Candidate> findCandidatesWithMatchingSkills(Job job, int page, int amount) {
        return new Pagination<Candidate>(candidateRepository.findCandidatesWithMatchingSkills(job.getId()), page, amount);
    }
}
