package iuh.edu.vn.www_week04_spring.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    @Column(name = "emp_id")
    private UUID id;
    @Column(name = "emp_name", length = 150, nullable = false)
    private String name;
}
