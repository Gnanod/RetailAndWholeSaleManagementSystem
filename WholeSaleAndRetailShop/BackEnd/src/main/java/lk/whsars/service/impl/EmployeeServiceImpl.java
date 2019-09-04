package lk.whsars.service.impl;


import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lk.whsars.entity.Employee;
import lk.whsars.repository.EmployeeRepository;
import lk.whsars.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(String employee_id) {


        employeeRepository.deleteById(Integer.parseInt(employee_id));

    }

    @Override
    public Employee UpdateEmployee(Employee employee) {

        return employeeRepository.save(employee);

    }


    @Override
    public Employee searchByEmployeeName(String fname){

        return employeeRepository.searchByEmployeeName(fname);

    }



}
