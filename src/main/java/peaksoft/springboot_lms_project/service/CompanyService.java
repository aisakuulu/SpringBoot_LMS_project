package peaksoft.springboot_lms_project.service;

import org.springframework.stereotype.Service;
import peaksoft.springboot_lms_project.entities.Company;
import peaksoft.springboot_lms_project.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }

    public void save(Company company){
        companyRepository.save(company);
    }

    public Company getById(Long id){
        return companyRepository.getById(id);
    }

    public void delete(Long id){
        companyRepository.deleteById(id);
    }

    public void updateCompany(Long id, Company updatedCompany){
        Company company = companyRepository.getById(id);
        company.setCompanyName(updatedCompany.getCompanyName());
        company.setLocatedCountry(updatedCompany.getLocatedCountry());
        companyRepository.save(company);
    }
}
