package iuh.edu.vn.www_week04_spring.entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int country;
    @Column(length = 7)
    private String zipcode;
    @Column(length = 20)
    private String number;
    @Column(length = 50)
    private String city;
    @Column(length = 150)
    private String street;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Company> companys = new ArrayList<>();

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Candidate> candidates = new ArrayList<>();

    public Address() {}

    public Address(String zipcode, String street,  String city, String number, int country) {
        this.country = country;
        this.zipcode = zipcode;
        this.number = number;
        this.city = city;
        this.street = street;
    }

    
}