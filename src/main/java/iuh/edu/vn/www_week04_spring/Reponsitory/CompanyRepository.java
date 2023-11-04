package iuh.edu.vn.www_week04_spring.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iuh.edu.vn.www_week04_spring.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
