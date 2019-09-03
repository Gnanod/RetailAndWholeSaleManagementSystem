package lk.whsars.controller;

import lk.whsars.entity.Company;
import lk.whsars.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/companyController")
public class CompanyController {


    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "/addCompany")
    public Company addCompany (@RequestBody Company company){
        return companyService.addCompany(company);
    }


    @GetMapping(value ="/getAllVehicle")
    public List<Company> getAllVehicle(){

        return companyService.getAllCompany();

    }
    @GetMapping(value = "/searchByCompanyName/{companyName}")
    public Company searchByCompanyName(@PathVariable String companyName){
        System.out.println("GGGGGGGGGGGGGGG");
        return companyService.searchByCompanyName(companyName);
    }


}
