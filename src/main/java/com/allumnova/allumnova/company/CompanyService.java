package com.allumnova.allumnova.company;

import java.util.List;

public interface CompanyService {
     List<Company> getAllCompany();
     boolean updateCompany(Company company,Integer id);
     void createCompany(Company company);
     boolean deleteCompanyById(Integer id);
     Company getCompanyById(Integer id);
}
