package lk.whsars.controller;

import lk.whsars.entity.Supplier;
import lk.whsars.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/SupplierController")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping(value = "/addAgent/{suppliername}")
    public List<Supplier> getAgentbyCompany(@PathVariable String suppliername){
        System.out.println("GGGGG"+suppliername);
        List<Supplier>l1= supplierService.getAgentBySupplier(suppliername);
        return l1;

    }
}
