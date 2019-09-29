package lk.whsars.service;

import lk.whsars.DTO.SupplierOrderSearchDto;
import lk.whsars.entity.Company;
import lk.whsars.entity.SupplierOrder;

import java.util.List;

public interface SupplierOrderService {

    SupplierOrder addSupplierOrder(SupplierOrder supplierOrder);

    String updateSupplierOrder(SupplierOrder supplierOrder);

    List<Company> getAllCompany();

    SupplierOrder addSupplierOrderToDb(SupplierOrder supplierOrder);

    SupplierOrderSearchDto searchByOrderId(Integer orderId);

    String deleteSupplierOrder(Integer orderId);

    SupplierOrderSearchDto searchOrderById(Integer orderId);

    List<SupplierOrderSearchDto> getAllOrders();
}
