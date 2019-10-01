package lk.whsars.repository;

import lk.whsars.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Integer> {

//    @Query(value ="select distinct i.barCode,i.itemName,i.itemQtyOnHand,b.brandName,a.supplierName,a.companyName from Item i ,Brand b,StockItemDetails sd, Stock s ,Supplier a  where  sd.stock.stockId=s.stockId and i.brand.brandId=b.brandId  and i.itemQtyOnHand < i.stockLevel and s.supplier.supplierId=a.supplierId")
   @Query(value = "select distinct bar_code,item_name,i.item_qty_on_hand,b.brand_name,a.supplier_name,a.company_name from item i,stock s,supplier a,brand b where  i.brand_brand_id=b.brand_id and item_qty_on_hand < stock_level and bar_code In(select item_bar_code from stock s,stock_item_details sd where s.stock_id=sd.stock_stock_id and s.supplier_supplier_id=a.supplier_id)",nativeQuery = true)
    List<Object[]> getLowStockLevelReport();

//select distinct bar_code,item_name,i.item_qty_on_hand,b.brand_name,a.supplier_name,a.company_name from item i,stock s,supplier a,brand b where  i.brand_brand_id=b.brand_id and item_qty_on_hand < stock_level and bar_code In(select item_bar_code from stock s,stock_item_details sd where s.stock_id=sd.stock_stock_id and s.supplier_supplier_id=a.supplier_id);

}
