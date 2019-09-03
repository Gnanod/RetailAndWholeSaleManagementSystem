package lk.whsars.repository;

import lk.whsars.DTO.SupplierOrderSearchDto;
import lk.whsars.entity.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder,String> {

//    @Query(value = "select so.companyName,so.date,s.supplierName from SupplierOrder so, SupplierOrderDetails sd,Supplier s where so.supplierOrderId = sd.supplierOrderSupplierOrderId")
//    SupplierOrder searchByOrderId(Integer supplier_order_supplier_order_id);
//

    @Query(value="select s.company,date,s.suppliername,so.status,so.total,so.supplierOrderId,s.supplierNic from Supplier s, SupplierOrder so where s.supplierNic=so.supplier.supplierNic and so.supplierOrderId=:supplierOrderId")
    List<Object[]> searchSupplierOrder(@Param("supplierOrderId")int supplierOrderId);

    @Query(value ="update SupplierOrder set status = 'true' where supplierOrderId=:supplierOrderId")
    Object updateSupplierOrder(@Param("supplierOrderId")int id);


}
