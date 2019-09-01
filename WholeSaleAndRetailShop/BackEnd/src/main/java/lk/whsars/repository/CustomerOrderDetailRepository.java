package lk.whsars.repository;

import lk.whsars.entity.CustomerOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collections;
import java.util.List;

public interface CustomerOrderDetailRepository extends JpaRepository<CustomerOrderDetail,String> {

    @Query(value = "from customer_order_detail where cus_order_detail_id=?1")
    static List<CustomerOrderDetail> findAllCustomerOrderDetails(String name){
        return Collections.emptyList();
    }
}
