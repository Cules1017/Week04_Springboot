package iuh.edu.vn.www_week04_spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.edu.vn.www_week04_spring.common.Pagination;
import iuh.edu.vn.www_week04_spring.entities.Candidate;
import iuh.edu.vn.www_week04_spring.entities.Job;
import iuh.edu.vn.www_week04_spring.entities.Skill;
import iuh.edu.vn.www_week04_spring.models.job.CandidateJobModel;
import iuh.edu.vn.www_week04_spring.services.implement.CandidateService;
import iuh.edu.vn.www_week04_spring.services.implement.SkillService;
import iuh.edu.vn.www_week04_spring.services.interfaces.IJobService;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateService candidateService;
    private final SkillService skillService;
    private final IJobService jobService;


    @Autowired
    public CandidateController(CandidateService candidateService, SkillService skillService, IJobService jobService) {
        this.candidateService = candidateService;
        this.skillService = skillService;
        this.jobService = jobService;
    }

    @GetMapping("/list")
    public String listCandidates(Model model,
             @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int amount,
            @RequestParam(value = "nameFilter", required = false) String nameFilter,
            @RequestParam(value = "skillFilter", required = false) List<Long> skillFilter) {

        Pagination<Candidate> paging = candidateService.getAllCandidates(page, amount, nameFilter, skillFilter);
        model.addAttribute("candidates", paging.getContent());
        model.addAttribute("page", page);
        model.addAttribute("amount", amount);
        model.addAttribute("totalPages", paging.getTotalPages());
        List<Skill> allSkills = skillService.getAllSkills();
        model.addAttribute("skills", allSkills);

        return "candidate/list";
    }
    
    @GetMapping("/{id}")
    public String listCandidates(Model model, @PathVariable("id") Long id) {
        Candidate candidate = candidateService.getById(id);
        if (candidate == null) {
            return "notFound";
        }
        model.addAttribute("candidate", candidate);
        List<Job> jobs = jobService.findJobsWithMatchingSkills(candidate);
        List<CandidateJobModel> candidateJobModels = jobs.stream().map(x -> new CandidateJobModel(x, candidate)).collect(Collectors.toList());
        model.addAttribute("jobs", candidateJobModels);

        return "candidate/detail";
    }
}

