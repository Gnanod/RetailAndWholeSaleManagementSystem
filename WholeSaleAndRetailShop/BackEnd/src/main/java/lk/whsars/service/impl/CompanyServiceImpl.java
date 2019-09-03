package lk.whsars.service.impl;

import lk.whsars.entity.Company;
import lk.whsars.repository.CompanyRepository;
import lk.whsars.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;



    @Override
    public Company addCompany(Company company){
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company searchByCompanyName(String companyName) {
        return companyRepository.searchByCompanyName(companyName);
    }
}
