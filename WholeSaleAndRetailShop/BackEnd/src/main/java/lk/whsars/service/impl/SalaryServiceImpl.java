package lk.whsars.service.impl;

import lk.whsars.DTO.SalarySheetDTO;
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

    public List<SalarySheetDTO> getSalaryDetails(){
        List<Object[]> sal = salaryRepository.getSalarydetails();

        List<SalarySheetDTO> sa = new ArrayList<>();
        for (Object b[] : sal){
            SalarySheetDTO sad = new SalarySheetDTO();

            sad.setEmployeeId(Integer.parseInt(b[0].toString()));
            sad.setEmpName(b[3].toString());
            sad.setRole(b[2].toString());
            sad.setBasicSal(b[1].toString());
            sad.setNetSal(b[4].toString());
            sad.setDate(b[5].toString());

            sa.add(sad);
            System.out.println("11111111111");
            System.out.println(sad.getRole()+sad.getEmpName()+sad.getNetSal()+sad.getBasicSal());

        }
        return sa;
    }
}
