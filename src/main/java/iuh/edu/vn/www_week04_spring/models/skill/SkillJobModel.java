package iuh.edu.vn.www_week04_spring.models.skill;

import iuh.edu.vn.www_week04_spring.common.Enum.SkillLevel;
import iuh.edu.vn.www_week04_spring.entities.Job_Skill;
import iuh.edu.vn.www_week04_spring.entities.Skill;
import lombok.Data;

@Data
public class SkillJobModel {
    private SkillLevel skill_level;
    private String more_infos;
    private Long skill_id;

    public Job_Skill ParseToEntity(Skill skill) {
        Job_Skill job_Skill = new Job_Skill();
        job_Skill.setMore_infos(more_infos);
        job_Skill.setSkill_level(skill_level);
        job_Skill.setSkill(skill);

        return job_Skill;
    }
}
