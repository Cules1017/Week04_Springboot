package iuh.edu.vn.www_week04_spring.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dob;
    private String phone;
    private String email;
    private String full_name;
    
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Candidate_Skill> candidate_skills = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Experience> experiences = new ArrayList<>();

    public Candidate() {}

    public Candidate(String full_name, Date dob, Address address, String phone, String email) {
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.full_name = full_name;
        this.address = address;
    }
}