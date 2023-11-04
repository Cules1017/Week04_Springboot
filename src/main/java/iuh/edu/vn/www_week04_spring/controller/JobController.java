package iuh.edu.vn.www_week04_spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.edu.vn.www_week04_spring.entities.Company;
import iuh.edu.vn.www_week04_spring.entities.Job;
import iuh.edu.vn.www_week04_spring.entities.Job_Skill;
import iuh.edu.vn.www_week04_spring.entities.Skill;
import iuh.edu.vn.www_week04_spring.models.job.CreateJobModel;
import iuh.edu.vn.www_week04_spring.services.implement.CompanyService;
import iuh.edu.vn.www_week04_spring.services.implement.SkillService;
import iuh.edu.vn.www_week04_spring.services.interfaces.IJobService;
import iuh.edu.vn.www_week04_spring.services.interfaces.IJobSkillService;

@Controller
public class JobController {

    @Autowired
    private IJobService jobService;
    
    @Autowired
    private CompanyService companyService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private IJobSkillService jobSkillService; 

    @GetMapping("/jobs")
    public String listJobs(Model model,
                           @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int amount) {
        Page<Job> jobPage = jobService.GetAll(page, amount);
        model.addAttribute("jobPage", jobPage);
        model.addAttribute("page", page);
        model.addAttribute("amount", amount);
        model.addAttribute("totalPages", jobPage.getTotalPages());
        return "/job/list";
    }
    
    @GetMapping("/job/{id}")
    public String showJobDetail(@PathVariable("id") Long jobId, Model model) {
        Job job = jobService.getJobById(jobId);

        if (job == null) {
            // Handle job not found
            return "jobNotFound";
        }

        model.addAttribute("job", job);
        return "job/detail";
    }
    
    @GetMapping("/create-job")
    public String createJobForm(Model model) {
        // Provide necessary data for the create job form, such as a list of companies and skills
        List<Company> companies = companyService.getAllCompanies();
        List<Skill> skills = skillService.getAllSkills();

        // Create a new Job object to bind form data
        CreateJobModel job = new CreateJobModel();
        model.addAttribute("job", job);
        model.addAttribute("companies", companies);
        model.addAttribute("skills", skills);

        return "job/create"; // Create an HTML form to capture job details
    }

    @PostMapping("/create-job")
    public String createJob(@ModelAttribute("CreateJobModel") CreateJobModel job) {
        Long companyId = job.getCompanyId();

        Company company = companyService.getCompanyById(companyId);
        
        if (company == null) 
        {
            return "error-page"; 
        }

        List<Job_Skill> skills = new ArrayList<Job_Skill>();
        for (String job_skill : job.getSkillJobModels()) {
            Skill skill = skillService.getSkillById(Long.parseLong(job_skill));
            if (skill == null) {
                return "error-page"; 
            }
            else {
                //skills.add(job_skill.ParseToEntity(skill));
                Job_Skill skillJob = new Job_Skill();
                skillJob.setSkill(skill);
                skills.add(skillJob);
            }
        }

        // Save the job entity
        Job newJob  = jobService.createJob(job.ParseToEntity(company));
        for(Job_Skill job_Skill : skills)
        {
            job_Skill.setJob(newJob);
            jobSkillService.createJobSkill(job_Skill);
        }

        return "redirect:/jobs"; // Redirect to the job listing page
    }
}
