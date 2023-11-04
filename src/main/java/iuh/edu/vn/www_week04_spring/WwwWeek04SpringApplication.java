package iuh.edu.vn.www_week04_spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import iuh.edu.vn.www_week04_spring.Reponsitory.AddressRepository;
import iuh.edu.vn.www_week04_spring.Reponsitory.CandidateRepository;
import iuh.edu.vn.www_week04_spring.Reponsitory.CandidateSkillRepository;
import iuh.edu.vn.www_week04_spring.Reponsitory.SkillRepository;
import iuh.edu.vn.www_week04_spring.common.Enum.SkillType;
import iuh.edu.vn.www_week04_spring.entities.Address;
import iuh.edu.vn.www_week04_spring.entities.Candidate;
import iuh.edu.vn.www_week04_spring.entities.Candidate_Skill;
import iuh.edu.vn.www_week04_spring.entities.Skill;

@SpringBootApplication
public class WwwWeek04SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(WwwWeek04SpringApplication.class, args);
    }

    @Autowired 
    private CandidateRepository candidateRepository; 
    @Autowired 
    private AddressRepository addressRepository;
    @Autowired 
    private SkillRepository skillRepository;
    @Autowired 
    private CandidateSkillRepository candidateSkillRepository;     

    @Bean 
    CommandLineRunner initData(){ 
       return args -> { 
           Random rnd = new Random();
           List<Skill> skills = new ArrayList<Skill>();
            skills.add(skillRepository.save(new Skill("Skill lord 1", "Lord lord lord", SkillType.TECHNICAL_SKILL)));
            skills.add(skillRepository.save(new Skill("Skill lord 2", "Lord lord lord", SkillType.SOFT_SKILL)));
            skills.add(skillRepository.save(new Skill("Skill lord 3", "Lord lord lord", SkillType.UNSPECIFIC)));
            skills.add(skillRepository.save(new Skill("Skill lord 4", "Lord lord lord", SkillType.UNSPECIFIC)));
            skills.add(skillRepository.save(new Skill("Skill lord 5", "Lord lord lord", SkillType.UNSPECIFIC))); 
            for (int i = 1; i < 1000; i++) { 
                Address add = new Address(rnd.nextInt(1,1000)+"", "Quang Trung", "HCM", 
                   rnd.nextInt(70000,80000)+"", 84 ); 
            addressRepository.save(add); 
 
            Candidate can=new Candidate("Name #"+i, 
                   new Date(1998,rnd.nextInt(1,13),rnd.nextInt(1,29)), 
                   add, 
                   rnd.nextLong(1111111111L,9999999999L)+"", 
                   "email_"+i+"@gmail.com"); 
            candidateRepository.save(can); 
            System.out.println("Added: " + can);
            
            List<Integer> nums = new ArrayList<Integer>();
            boolean[] check = new boolean[skills.size()];
               for (int j = 0; j < 8; j++) {
                   int index = rnd.nextInt(skills.size());
                   if (!check[index]) {
                       nums.add(index);
                       check[index] = true;
                   }
               }
               for (Integer index : nums) {
                   Candidate_Skill can_skill = new Candidate_Skill(can, skills.get(index), 0,
                           "Skill lord lord");
                   candidateSkillRepository.save(can_skill);
               }
          } 
       }; 
    }
}
