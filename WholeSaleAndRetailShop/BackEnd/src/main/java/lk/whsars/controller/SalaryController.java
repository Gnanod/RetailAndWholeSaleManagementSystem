package lk.whsars.controller;

import lk.whsars.Common.SalarySheet;
import lk.whsars.DTO.SalarySheetDTO;
import lk.whsars.entity.Employee;
import lk.whsars.entity.Salary;
import lk.whsars.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/salaryController")

public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping(value = "/getempdetails")
    public List getEmpDetails(){
        return salaryService.getEmpDetails();
    }

    @GetMapping(value = "/searchById/{empId}")
    public Employee searchById(@PathVariable String empId){
        return salaryService.searchById(empId);
    }

    @PostMapping(value = "/addSal")
        public Salary addSalary(@RequestBody Salary salary){
        System.out.println(salary);
        return salaryService.addSalary(salary);
    }
    @GetMapping(value = "/salSum")
    public String salarySum(){
        System.out.println("aaahaa");
        return  salaryService.salarySum();
    }
    @GetMapping(value = "salarysheet")
    public List<SalarySheetDTO> getSalaryDetails(){
        return salaryService.getSalaryDetails();
    }

    @PostMapping(value = "Printsalary")
    public String printSalary(@RequestBody ArrayList<SalarySheetDTO> salary){
        SalarySheet sal = new SalarySheet();
        sal.generateSalarySheetPdf(salary);
         return null;
    }

    @GetMapping(value = "/workday")
    public String workdays(@PathVariable int id){
        return salaryService.workdays(id);
    }

}
