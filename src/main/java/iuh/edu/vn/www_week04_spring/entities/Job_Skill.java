package iuh.edu.vn.www_week04_spring.entities;
import iuh.edu.vn.www_week04_spring.common.Enum.SkillLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@IdClass(JobSkillId.class)
@Data
public class Job_Skill {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    private SkillLevel skill_level;
    private String more_infos;
}



