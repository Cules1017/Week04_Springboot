package iuh.edu.vn.www_week04_spring.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.edu.vn.www_week04_spring.Reponsitory.CompanyRepository;
import iuh.edu.vn.www_week04_spring.entities.Company;
import iuh.edu.vn.www_week04_spring.services.interfaces.ICompanyService;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.getById(id);
    }
}
