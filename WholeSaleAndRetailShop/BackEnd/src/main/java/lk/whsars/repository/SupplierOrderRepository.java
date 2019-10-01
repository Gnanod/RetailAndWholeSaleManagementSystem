package lk.whsars.repository;

import lk.whsars.DTO.SupplierOrderSearchDto;
import  lk.whsars.entity.Supplier;
import lk.whsars.entity.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder,Integer> {

//    @Query(value = "select so.companyName,so.date,s.supplierName from SupplierOrder so, SupplierOrderDetails sd,Supplier s where so.supplierOrderId = sd.supplierOrderSupplierOrderId")
//    SupplierOrder searchByOrderId(Integer supplier_order_supplier_order_id);
//

    @Query(value="select s.companyName,so.date,s.supplierName,so.status,so.total,so.supplierOrderId,s.supplierNic,s.supplierId from Supplier s, SupplierOrder so where s.supplierNic=so.supplier.supplierNic and so.supplierOrderId=:supplierOrderId")
    List<Object[]> searchSupplierOrder(@Param("supplierOrderId")int supplierOrderId);

    @Query(value ="update SupplierOrder set status = 'true' where supplierOrderId=:supplierOrderId")
    Object updateSupplierOrder(@Param("supplierOrderId")int id);

    @Query(value = "select s.companyName,so.date,s.supplierName,so.status,so.total,so.supplierOrderId from Supplier s, SupplierOrder so where s.supplierNic=so.supplier.supplierNic and so.supplierOrderId=:supplierOrderId and so.status='false'")
    List<Object[]> searchSupOrderDelete(@Param("supplierOrderId")int supplierOrderId);

    @Query(value = "select s.supplierOrderId,su.supplierId,s.companyName,su.supplierName,s.date,s.total,s.status from SupplierOrder s,Supplier su where s.status='TRUE' and  s.supplier.supplierId= su.supplierId")
    List<Object[]> receivedSupOrders();


}
