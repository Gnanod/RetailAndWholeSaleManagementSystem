package lk.whsars.repository;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lk.whsars.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //void deleteById(int employeeId);
    @Query(value = "select a.employee_employee_id, a.in_time, a.out_time, a.day, e.fname,e.lname,e.role from employee e, attendance a where e.employee_id = a.employee_employee_id and month(a.day)= month(current_date) and out_time is Not NULL and lname is Not NULL",nativeQuery = true)
    List<Object[]> getEmployeeAttendance();


    @Query(value = "from Employee where fname =?1")
    Employee searchByEmployeeName(String fname);


}
