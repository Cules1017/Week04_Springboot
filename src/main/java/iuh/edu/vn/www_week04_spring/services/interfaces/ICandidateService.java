package iuh.edu.vn.www_week04_spring.services.interfaces;

import java.util.List;

import iuh.edu.vn.www_week04_spring.common.Pagination;
import iuh.edu.vn.www_week04_spring.entities.Candidate;
import iuh.edu.vn.www_week04_spring.entities.Job;

public interface ICandidateService {
    Pagination<Candidate> getAllCandidates(int page, int amount, String nameFilter, List<Long> skillFilter);

    Candidate getById(Long id);

    Pagination<Candidate> findCandidatesWithMatchingSkills(Job job, int page, int amount);
}
