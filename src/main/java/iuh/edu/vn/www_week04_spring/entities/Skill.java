package iuh.edu.vn.www_week04_spring.entities;
import java.util.ArrayList;
import java.util.List;

import iuh.edu.vn.www_week04_spring.common.Enum.SkillType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private SkillType skill_type;
    private String skill_name;
    private String skill_desc;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Job_Skill> job_skills = new ArrayList<>();

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Candidate_Skill> candidate_skills = new ArrayList<>();

    public Skill() {
    }
    
    public Skill(String name, String description, SkillType type) {
        this.skill_name = name;
        this.skill_desc = description;
        this.skill_type = type;
    }   
}