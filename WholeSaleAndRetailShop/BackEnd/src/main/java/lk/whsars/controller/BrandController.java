package lk.whsars.controller;


import lk.whsars.entity.Brand;
import lk.whsars.entity.Customer;
import lk.whsars.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/BrandController")
public class BrandController {
    
    @Autowired
    private BrandService brandService;
    
    
    @PostMapping(value = "/addBrand")
    public Brand addBrand(@RequestBody Brand brand){

       
        return brandService.addBrand(brand);
    }


    @GetMapping(value = "/getAllBrand")
    public List<Brand> getAllCustomers(){

        return  brandService.getAllBrands();
    }

    @DeleteMapping(value = "/deleteBrand/{brandId}")
    public String deleteBrand(@PathVariable int brandId){

        return  brandService.deleteBrand(brandId);

    }
}
