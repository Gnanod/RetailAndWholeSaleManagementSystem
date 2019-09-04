package lk.whsars.controller;

import lk.whsars.entity.Supplier;
import lk.whsars.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/supplierController")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @PostMapping(value = "/addSupplier")
    public Supplier addSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }


    @GetMapping(value = "/getAllSupplier")
    public List<Supplier> getAllSupplier(){
        return supplierService.getAllSupplier();
    }

    @GetMapping(value = "/searchBySupplierNic/{supplierNic}")
    public Supplier searchBySupplierNic(@PathVariable String supplierNic){
        return supplierService.searchBySupplierNic(supplierNic);
    }

    @PostMapping( "/updateSupplierDetails")
    public Supplier updateSupplierDetails(@RequestBody Supplier supplier){
        return supplierService.updateSupplier(supplier);
    }

//    @DeleteMapping("/deleteSupplier/{supplierNic}")
//     String deleteSupplier(@PathVariable Supplier supplierNic){
//        System.out.println("8888ß");
//        supplierService.deleteSupplier(supplierNic);
//        return "9";
//    }
        @DeleteMapping("/deleteSupplier/{supplierNic}")
        String deleteSupplier(@PathVariable int supplierNic){
            System.out.println("8888ß");
            String value = supplierService.deleteSup(supplierNic);

            return "9";
        }


}
