package lk.whsars.service.impl;

import lk.whsars.entity.Brand;
import lk.whsars.entity.Customer;
import lk.whsars.repository.BrandRepository;
import lk.whsars.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    
    @Autowired
    private BrandRepository brandRepository;
    
    @Override
    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public String deleteBrand(int brandId) {

        brandRepository.deleteById(brandId);
        return "9";
    }
}
