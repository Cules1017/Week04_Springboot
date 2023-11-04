package iuh.edu.vn.www_week04_spring.models.candidate;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import iuh.edu.vn.www_week04_spring.entities.Candidate;
import iuh.edu.vn.www_week04_spring.entities.Job;
import lombok.Data;

@Data
public class JobCandidateModel {
    private Long id;
    private Date dob;
    private String phone;
    private String email;
    private String address;
    private String full_name;
    private String missingSkill;
    public JobCandidateModel(Candidate candidate, Job job) {
        this.id = candidate.getId();
        this.dob = candidate.getDob();
        this.phone = candidate.getPhone();
        this.email = candidate.getEmail();
        this.full_name = candidate.getFull_name();
        this.address = candidate.getAddress().getCity();

        List<String> jobSkills = job.getJob_skills().stream().map(x -> x.getSkill().getSkill_name()).collect(Collectors.toList());
        List<String> candidateSkills = candidate.getCandidate_skills().stream().map(x -> x.getSkill().getSkill_name()).collect(Collectors.toList());
        jobSkills.removeAll(candidateSkills);
        this.missingSkill = String.join(",", jobSkills);
    }
    
    
}
