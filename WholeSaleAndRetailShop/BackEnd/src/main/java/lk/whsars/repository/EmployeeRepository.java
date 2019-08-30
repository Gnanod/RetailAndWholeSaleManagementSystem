package lk.whsars.repository;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lk.whsars.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //void deleteById(int employeeId);

    @Query(value = "from Employee where fname = ?1")
    Employee searchByEmployeeName(String fname);


}
