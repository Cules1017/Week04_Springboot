package iuh.edu.vn.www_week04_spring.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
// Create constructor 1 arg
@ToString
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")

    private long id;
    @Column(name = "dept_name", length = 140, nullable = false)
    @NonNull
    private String name;

}
