package iuh.edu.vn.www_week04_spring.entities;

import java.io.Serializable;

import lombok.Data;

// @Data
// public class JobSkillId implements  Serializable {
//     private Job job;
//     private Skill skill;
// }

@Data
public class JobSkillId implements Serializable {
    private Long job;
    private Long skill;
}
