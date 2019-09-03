package lk.whsars.repository;



import lk.whsars.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,String> {

    @Query(value = "from Item  where itemName like %?1")
    List<Item> findAllItemsByName(String name);

    @Query(value = "from Item  where itemName=?1")
    Item searchByProductName(String productName);

    @Query(value = "from Item  where barCode like %?1")
    Item findAllItemsByBarcode(String searchBarcode);

    @Query(value = "from Item  where barCode = ?1")
    Item findAllItemsByBarcodeNotLike(String searchBarcode);
}
