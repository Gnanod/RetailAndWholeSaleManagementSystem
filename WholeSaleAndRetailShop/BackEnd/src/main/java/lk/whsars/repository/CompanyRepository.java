package lk.whsars.repository;

import lk.whsars.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    @Query(value = "from Company where companyName=?1")
    Company searchByCompanyName(String company_name);


}
