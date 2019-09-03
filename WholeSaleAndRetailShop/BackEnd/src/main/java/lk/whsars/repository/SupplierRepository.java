package lk.whsars.repository;

import lk.whsars.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

    @Query(value = "from Supplier where supplierNic=?1")
    Supplier searchBySupplierNic(String supplier_Nic);

    @Query(value = "delete from Supplier where supplierNic = :supplierNic")
    Object deleteSupplier(@Param("supplierNic") String supplierNic);
}

