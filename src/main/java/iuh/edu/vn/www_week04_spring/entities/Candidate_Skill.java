package iuh.edu.vn.www_week04_spring.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@IdClass(CandidateSkillId.class)
@Data
public class Candidate_Skill {
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    private int skill_level;
    private String more_infos;

    public Candidate_Skill() { }

    public Candidate_Skill(Candidate candidate, Skill skill, int skill_level, String more_infos) {
        this.candidate = candidate;
        this.skill = skill;
        this.skill_level = skill_level;
        this.more_infos = more_infos;
    }
}



