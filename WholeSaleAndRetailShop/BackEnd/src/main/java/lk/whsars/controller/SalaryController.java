package lk.whsars.controller;

import lk.whsars.entity.Employee;
import lk.whsars.entity.Salary;
import lk.whsars.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("aaahfhfhfhfhfhfhf");
        return  salaryService.salarySum();
    }
}
