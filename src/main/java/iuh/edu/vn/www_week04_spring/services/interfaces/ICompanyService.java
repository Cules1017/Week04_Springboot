package iuh.edu.vn.www_week04_spring.services.interfaces;

import java.util.List;

import iuh.edu.vn.www_week04_spring.entities.Company;
import iuh.edu.vn.www_week04_spring.entities.Skill;

public interface ICompanyService {
    Company createCompany(Company company);

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);
}
