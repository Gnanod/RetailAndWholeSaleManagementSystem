package lk.whsars.controller;


import lk.whsars.entity.Company;
import lk.whsars.entity.Supplier;
import lk.whsars.entity.SupplierOrder;
import lk.whsars.entity.SupplierOrderDetail;
import lk.whsars.service.SupplierOrderService;
import lk.whsars.service.SupplierServiceH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/SupplierOrderController")
public class SupplierOrderController {

    @Autowired
    private SupplierOrderService supplierOrderService;

    @Autowired
    private SupplierServiceH supplierServiceH;

    @PostMapping(value = "addSupplierOrder")
    public SupplierOrder addSupplierOrder(@RequestBody SupplierOrder supplierOrder){

        return supplierOrderService.addSupplierOrder(supplierOrder);
    }

    @PostMapping(value = "updateSupplierOrder")
    public SupplierOrder updateSupplierOrder(@RequestBody SupplierOrder supplierOrder){

        return supplierOrderService.updateSupplierOrder(supplierOrder);
    }

    @GetMapping(value ="/getAllCompany")
    public List<Company> getAllCompany(){

        return supplierOrderService.getAllCompany();
    }


    @GetMapping(value ="/getMakeAgent/{companyName}")
    public List<Supplier> getAllAgentsformCompany(@PathVariable String companyName){

        System.out.println("print" + companyName );

        List<Supplier> s1 = supplierServiceH.getAllAgentsformCompany(companyName);
        for (Supplier f: s1
             ) {

            f.getSuppliername();
            System.out.println( "LLLLLL"+f.getSuppliername());
        }

        return s1;
    }
}
