package iuh.edu.vn.www_week04_spring.entities;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Experience {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date from_date;
    private Date to_date;
    private String role;
    private String company;
    private String work_desc;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
}