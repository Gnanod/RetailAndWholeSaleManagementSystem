package lk.whsars.repository;



import lk.whsars.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,String> {

    @Query(value = "from Item  where itemName=?1")
    List<Item> findAllItemsByName(String name);
}
