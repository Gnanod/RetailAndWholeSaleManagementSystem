package lk.whsars.repository;

import lk.whsars.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

//    @Query(value = "from Supplier where supplierName =?1")
//    Supplier getAgentBySupplier(suppliername);
}
