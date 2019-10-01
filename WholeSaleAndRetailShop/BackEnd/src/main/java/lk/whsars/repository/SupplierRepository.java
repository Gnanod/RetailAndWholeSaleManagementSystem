package lk.whsars.repository;

import lk.whsars.entity.Company;
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


    @Query(value = "select supplier_name,supplier_nic,address,email,phone,date from Supplier where month(date) = month(current_date )",nativeQuery = true)
    List<Object[]>getSupplierDetailsReport();

    @Query(value = "select * from company",nativeQuery = true)
    List<Company> searchByCompanyName();

}

