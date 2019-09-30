package lk.whsars.service.impl;


import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lk.whsars.DTO.EmployeeAttendanceDto;
import lk.whsars.DTO.LowStockLevelDto;
import lk.whsars.entity.*;
import lk.whsars.repository.AttendanceRepository;
import lk.whsars.repository.EmployeeRepository;
import lk.whsars.repository.ItemRepository;
import lk.whsars.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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




    @Override
    public List<EmployeeAttendanceDto> getEmployeeAttendance() {
        List<Object[]> employeeAttendance = employeeRepository.getEmployeeAttendance();

        List<EmployeeAttendanceDto> a = new ArrayList<>();
        for ( Object ob []: employeeAttendance
        ) {

            EmployeeAttendanceDto a1 = new EmployeeAttendanceDto();

            a1.setAttendanceId(Integer.parseInt(ob[0].toString()));
            a1.setInTime(ob[1].toString());
            a1.setOutTime(ob[2].toString());
            a1.setDay(ob[3].toString());
            a1.setFname(ob[4].toString());
            a1.setLname(ob[5].toString());
            a1.setRole(ob[6].toString());


            a.add(a1);

        }


        return a;
    }


}
