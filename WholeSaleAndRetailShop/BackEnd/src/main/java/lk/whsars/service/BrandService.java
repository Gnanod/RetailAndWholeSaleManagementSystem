package lk.whsars.service;

import lk.whsars.entity.Brand;
import lk.whsars.entity.Customer;

import java.util.List;

public interface BrandService {
    
    Brand addBrand(Brand brand);

    List<Brand> getAllBrands();
}
