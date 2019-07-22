package lk.whsars.repository;

import lk.whsars.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer> {


}
