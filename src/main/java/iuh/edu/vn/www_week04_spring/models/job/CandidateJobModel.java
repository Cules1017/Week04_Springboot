package iuh.edu.vn.www_week04_spring.models.job;

import java.util.List;
import java.util.stream.Collectors;

import iuh.edu.vn.www_week04_spring.entities.Candidate;
import iuh.edu.vn.www_week04_spring.entities.Job;
import lombok.Data;

@Data
public class CandidateJobModel {
    private Long Id;
    private String job_desc;
    private String job_name;
    private String companyName;
    private String missingSkill;

    public CandidateJobModel(Job job, Candidate candidate) {
        this.Id = job.getId();
        this.job_desc = job.getJob_desc();
        this.job_name = job.getJob_name();
        this.companyName = job.getCompany().getComp_name();
        List<String> jobSkills = job.getJob_skills().stream().map(x -> x.getSkill().getSkill_name()).collect(Collectors.toList());
        List<String> candidateSkills = candidate.getCandidate_skills().stream().map(x -> x.getSkill().getSkill_name()).collect(Collectors.toList());
        jobSkills.removeAll(candidateSkills);
        this.missingSkill = String.join(",", jobSkills);
    }
}
