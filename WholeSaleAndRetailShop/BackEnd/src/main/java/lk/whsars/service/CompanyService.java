package lk.whsars.service;

import lk.whsars.entity.Company;

import java.util.List;

public interface CompanyService {

    Company addCompany(Company company);

    List<Company> getAllCompany();

    Company searchByCompanyName(String companyName);
}
