package lk.whsars.service;

import lk.whsars.entity.Company;
import lk.whsars.entity.Supplier;
import lk.whsars.entity.SupplierOrder;

import java.util.List;

public interface SupplierOrderService {

    SupplierOrder addSupplierOrder(SupplierOrder supplierOrder);

    SupplierOrder updateSupplierOrder(SupplierOrder supplierOrder);

    List<Company> getAllCompany();



}
