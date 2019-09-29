package lk.whsars.repository;

import lk.whsars.entity.Employee;
import lk.whsars.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary,Integer> {

//    @Query(value = "select employee_id,role,fname,basicsal from employee",nativeQuery = true)
//    List getEmpDetails();

    @Query(value ="from Employee where employee_id=?1")
     Employee searchById(int empId);

    @Query(value = "select sum(salary) from salary",nativeQuery = true)
    Object salarySum();

    @Query(value = "select e.employee_id,e.basicsal,e.role,e.fname,s.salary,s.pay_date from employee e,salary s where e.employee_id=s.employee_employee_id and month(s.pay_date) = month(current_date)",nativeQuery = true)
    List<Object[]> getSalarydetails();
}
