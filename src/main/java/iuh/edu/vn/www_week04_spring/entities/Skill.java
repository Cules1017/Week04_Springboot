package iuh.edu.vn.www_week04_spring.entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int skill_type;
    private String skill_name;
    private String skill_desc;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private List<Job_Skill> job_skills = new ArrayList<>();

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private List<Job_Skill> candidate_skills = new ArrayList<>();
}