package lk.whsars.repository;

import lk.whsars.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierRepositoryH extends JpaRepository<Supplier,Integer> {

    @Query(value="select suppliername from Supplier where company = :companyName")
    List<Object[]> getAllAgentsformCompany(@Param("companyName")String companyName);
}
