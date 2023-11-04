package iuh.edu.vn.www_week04_spring.models.job;

import iuh.edu.vn.www_week04_spring.entities.Company;
import iuh.edu.vn.www_week04_spring.entities.Job;
import lombok.Data;

@Data
public class CreateJobModel {
    private String job_desc;
    private String job_name;
    private Long companyId;
    private String[] SkillJobModels;

    public Job ParseToEntity(Company company) {
        Job job = new Job();
        job.setCompany(company);
        job.setJob_desc(job_desc);
        job.setJob_name(job_name);

        return job;
    }
}
