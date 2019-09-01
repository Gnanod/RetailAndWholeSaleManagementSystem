package lk.whsars.repository;

import lk.whsars.entity.Company;
import lk.whsars.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepoH extends JpaRepository<Company,Integer> {

}
