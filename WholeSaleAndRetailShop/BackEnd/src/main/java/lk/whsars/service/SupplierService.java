package lk.whsars.service;

import lk.whsars.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAgentBySupplier(String agentName);


    Supplier addSupplier(Supplier supplier);

    List<Supplier> getAllSupplier();

    Supplier searchBySupplierNic(String supplierNic);


    Supplier updateSupplier(Supplier supplier);


    void deleteSupplier(Supplier supplierNic);

    String deleteSuppliers(String supplierNic);

    String deleteSup(int supplierNic);


}
