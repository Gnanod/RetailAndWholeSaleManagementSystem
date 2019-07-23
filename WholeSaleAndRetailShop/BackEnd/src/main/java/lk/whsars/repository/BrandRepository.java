package lk.whsars.repository;

import lk.whsars.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    
}
