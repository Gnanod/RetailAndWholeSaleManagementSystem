package lk.whsars.repository;

import lk.whsars.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Integer> {

    @Query(value ="select distinct i.barCode,i.itemName,i.itemQtyOnHand,b.brandName,a.supplierName,a.companyName from Item i ,Brand b,StockItemDetails sd, Stock s ,Supplier a  where  sd.stock.stockId=s.stockId and i.brand.brandId=b.brandId  and i.itemQtyOnHand < i.stockLevel and s.supplier.supplierId=a.supplierId")
    List<Object[]> getLowStockLevelReport();

//    select bar_code,item_name,item_qty_on_hand,brand_name,a.supplier_name,company from item i ,brand b,stock_item_details sd, stock s ,supplier a where sd.stock_stock_id=s.stock_id and  i.brand_brand_id=b.brand_id and item_qty_on_hand<stock_level and s.supplier_supplier_id=a. supplier_id;


}
