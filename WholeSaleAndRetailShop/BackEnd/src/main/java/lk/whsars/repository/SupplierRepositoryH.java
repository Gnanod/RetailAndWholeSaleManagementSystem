package lk.whsars.repository;

import lk.whsars.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierRepositoryH extends JpaRepository<Supplier,Integer> {

    @Query(value="select supplierName,supplierNic from Supplier where company = :companyName")
    List<Object[]> getAllAgentsformCompany(@Param("companyName")String companyName);

    @Query(value="select i.barCode,i.itemName,i.retailPrice from Stock s,StockItemDetails si,Item i where i.barCode = si.item.barCode and si.stock.stockId = s.stockId and s.supplier.supplierNic IN (  SELECT supplierNic  FROM Supplier WHERE supplierNic=:nic)")
    List<Object[]> getAllItemsToCart(@Param("nic")String nic);



}
