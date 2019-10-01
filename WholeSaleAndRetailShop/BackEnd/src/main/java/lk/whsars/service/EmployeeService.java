package lk.whsars.service;

import lk.whsars.DTO.EmployeeAttendanceDto;
import lk.whsars.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    void deleteEmployee(String employee_id);

    Employee UpdateEmployee(Employee employee);

    Employee searchByEmployeeName(String fname);

    List<EmployeeAttendanceDto> getEmployeeAttendance();



}

