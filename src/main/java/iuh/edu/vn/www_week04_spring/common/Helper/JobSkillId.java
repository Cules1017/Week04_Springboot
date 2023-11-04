package iuh.edu.vn.www_week04_spring.common.Helper;

import java.io.Serializable;

import lombok.Data;

@Data
public class JobSkillId implements Serializable {
    private Long job;   
    private Long skill; 
}

