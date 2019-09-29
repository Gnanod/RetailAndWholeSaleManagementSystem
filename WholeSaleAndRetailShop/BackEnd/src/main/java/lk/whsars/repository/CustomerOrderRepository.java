package lk.whsars.repository;

import lk.whsars.entity.CustomerOrder;
import lk.whsars.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer> {

    @Query(value = "from Item  where itemName=?1 or barCode=?1")
    List<Item> findAllItemsByNameOrId(String nameOrId);

    @Query(value = "from Item  where barCode = ?1")
    List<Item> getAllItems(String searchName);

    @Query(value = "SELECT * FROM customer_order ORDER BY customer_order_id DESC LIMIT 1",nativeQuery = true)
    List<Object[]> getLastOrder();

    @Query(value ="select a.customer_order_id,sum(a.total_price) as total_price, sum(a.discount) as discount,a.customer_cusid,c.phone from customer_order a,customer c where c.cusid = a.customer_cusid group by a.customer_cusid",nativeQuery = true)
    List<Object[]> getCustomerOrderReport();

}
