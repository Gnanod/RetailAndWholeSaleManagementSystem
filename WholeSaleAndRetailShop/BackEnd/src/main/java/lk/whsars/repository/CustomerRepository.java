package lk.whsars.repository;

import lk.whsars.DTO.CustomerRDto;
import lk.whsars.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {





    @Query(value = "from Customer  where nic=?1")
    Customer searchByCustomerDetailsByNIC(String nic);

    @Query(value = "from Customer  where phone=?1")
    Customer searchByCustomerDetailsByID(String phone);

    @Query(value = "select userName,nic,email,type,loyaltyPoints from Customer")
    List<Object[]> getCusRDetails();
}
