package com.allumnova.allumnova.company.impl;

import com.allumnova.allumnova.company.Company;
import com.allumnova.allumnova.company.CompanyRepository;
import com.allumnova.allumnova.company.CompanyService;
import com.allumnova.allumnova.job.Job;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override


    @Transactional  // Ensure jobs are loaded inside the session
    public List<Company> getAllCompany() {
        List<Company> companies = companyRepository.findAll();
        companies.forEach(company -> company.getJobs().size());  // Force loading jobs
        return companies;
    }
    @Override
    public boolean updateCompany(Company company, Integer id) {
        Optional<Company> companyOptional=companyRepository.findById(id);

        if (companyOptional.isPresent()){
            Company companytoupdate =companyOptional.get() ;
            companytoupdate.setName(company.getName());
            companytoupdate.setDescription(company.getDescription());
            companytoupdate.setJobs(company.getJobs());

            companyRepository.save(companytoupdate);
           return true;
        }
else return false;

    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Integer id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Integer id) {

            return companyRepository.findById(id).orElse(null);


    }


}
