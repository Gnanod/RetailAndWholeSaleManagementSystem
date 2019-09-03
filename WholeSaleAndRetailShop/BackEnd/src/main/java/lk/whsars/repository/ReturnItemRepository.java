package lk.whsars.repository;
import lk.whsars.entity.Item;
import lk.whsars.entity.ReturnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReturnItemRepository extends JpaRepository<ReturnItem,Integer>{

    @Query(value = "select i.barCode, i.itemName, c.qty from CustomerOrderDetail c, Item i where i.barCode = c.item.barCode and c.customerOrder.customerOrderId=?1")
    List<Object[]> searchItemByOrderId(int orderId);

    @Query(value = "select  retItemId, retItemBarcode,retDate,retItemName,retQuant,resellableQuant,notresellableQuant from ReturnItem ")
    List<Object[]> getAllDetsails();
}
