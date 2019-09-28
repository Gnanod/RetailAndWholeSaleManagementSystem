package lk.whsars.repository;

import lk.whsars.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "from Customer  where nic=?1")
    Customer searchByCustomerDetailsByNIC(String nic);

    @Query(value = "from Customer  where cusID=?1")
    Customer searchByCustomerDetailsByID(int cusID);
}
