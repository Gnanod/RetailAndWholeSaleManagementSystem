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
}
