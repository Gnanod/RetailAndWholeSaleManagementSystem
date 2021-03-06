package lk.whsars.controller;

import lk.whsars.Common.EmployeeAttendanceReport;
import lk.whsars.Common.LowStockLevelReport;
import lk.whsars.DTO.EmployeeAttendanceDto;
import lk.whsars.DTO.LowStockLevelDto;
import lk.whsars.entity.Employee;
import lk.whsars.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/EmployeeController")
class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){

        return  employeeService.addEmployee(employee);
    }


    @GetMapping(value = "/getAllEmployee")
    public List<Employee> getAllEmployee(){

        return employeeService.getAllEmployee();
    }


    @DeleteMapping("/deleteEmployee/{employee_id}")
    void deleteEmployee(@PathVariable String employee_id) {
        employeeService.deleteEmployee(employee_id);
    }




    @PostMapping(value = "/updateEmployee")
    public Employee UpdateEmployee(@RequestBody Employee employee){

        return employeeService.UpdateEmployee(employee);

    }



    @GetMapping(value ="/searchByEmployeeName/{fname}")
    public Employee searchByEmployeeName(@PathVariable String fname){

        return employeeService.searchByEmployeeName(fname);

    }

    @GetMapping(value = "/getEmployeeAttendance")
    public List<EmployeeAttendanceDto> getItems(){

        return employeeService.getEmployeeAttendance();

    }

    @PostMapping(value = "/printReport")
    public String printReport(@RequestBody ArrayList<EmployeeAttendanceDto> employeeAttendanceDto){

        EmployeeAttendanceReport e1 = new EmployeeAttendanceReport();
        e1.generateEmployeeAttendancePdf(employeeAttendanceDto);

        return "1";

    }


}


