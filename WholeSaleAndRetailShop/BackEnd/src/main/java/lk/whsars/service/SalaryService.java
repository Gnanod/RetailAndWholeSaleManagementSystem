package lk.whsars.service;

import lk.whsars.DTO.SalarySheetDTO;
import lk.whsars.entity.Employee;
import lk.whsars.entity.Salary;

import java.util.List;

public interface SalaryService {

    List getEmpDetails();

   Employee searchById(String empId);

    Salary addSalary(Salary salary);

    String salarySum();

    List<SalarySheetDTO> getSalaryDetails();
}
