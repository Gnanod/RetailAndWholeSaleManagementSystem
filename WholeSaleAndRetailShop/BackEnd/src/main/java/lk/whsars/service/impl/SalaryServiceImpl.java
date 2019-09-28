package lk.whsars.service.impl;

import lk.whsars.entity.Employee;
import lk.whsars.entity.Salary;
import lk.whsars.repository.SalaryRepository;
import lk.whsars.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public List  getEmpDetails() {
        return salaryRepository.findAll();
    }

    @Override
    public  Employee searchById(String empId) {

        Employee s1 = salaryRepository.searchById (Integer.parseInt(empId));
        return salaryRepository.searchById (Integer.parseInt(empId));
    }

    @Override
    public Salary addSalary(Salary salary) {
        System.out.println("aaaaa");
        return salaryRepository.save(salary);
    }

    public String salarySum(){
         Object sal= salaryRepository.salarySum();
         String a = sal.toString();
        System.out.println("aaaaaaa"+a);
         return a;
    }
}
