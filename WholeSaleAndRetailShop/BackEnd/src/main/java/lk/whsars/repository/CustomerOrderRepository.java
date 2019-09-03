package lk.whsars.repository;

import lk.whsars.entity.CustomerOrder;
import lk.whsars.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,String> {

    @Query(value = "from Item  where itemName=?1 or barCode=?1")
    List<Item> findAllItemsByNameOrId(String nameOrId);

    @Query(value = "from Item  where barCode = ?1")
    List<Item> getAllItems(String searchName);


//    @Query(value = "SELECT * FROM CustomerOrder")
//    List<CustomerOrder>

}
