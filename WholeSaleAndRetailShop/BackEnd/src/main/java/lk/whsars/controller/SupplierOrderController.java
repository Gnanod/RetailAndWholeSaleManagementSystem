package lk.whsars.controller;


import lk.whsars.Common.ReceivedOrderReport;
import lk.whsars.DTO.SupplierOrderSearchDto;
import lk.whsars.entity.*;
import lk.whsars.service.SupplierOrderService;
import lk.whsars.service.SupplierServiceH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String updateSupplierOrder(@RequestBody SupplierOrder supplierOrder){

        String s1 = supplierOrderService.updateSupplierOrder(supplierOrder);

        if(s1!=null){

            return "9";

        }else{
            return null;

        }
    }

    @GetMapping(value ="/getAllCompany")
    public List<Company> getAllCompany(){

        return supplierOrderService.getAllCompany();
    }


    @GetMapping(value ="/getMakeAgent/{companyName}")
    public List<Supplier> getAllAgentsformCompany(@PathVariable String companyName){

        System.out.println("print" + companyName );

        List<Supplier> s1 = supplierServiceH.getAllAgentsformCompany(companyName);


        return s1;
    }



    @GetMapping(value ="/getItemDetails/{nic}")
    public List<Item> getAllItemsToCart(@PathVariable String nic){

        System.out.println("KKKKKKK");

        List<Item> s1 = supplierServiceH.getAllItemsToCart(nic);


        return s1;
    }


    @PostMapping(value = "/saveJoBOrder")
    public String addSupplierOrderToDb(@RequestBody SupplierOrder supplierOrder){

        SupplierOrder s1 = supplierOrderService.addSupplierOrderToDb(supplierOrder);

        return "9";
    }

    @GetMapping(value = "/getSupplierOrder/{orderId}")
    public SupplierOrderSearchDto searchByOrderId(@PathVariable Integer orderId){
        System.out.println("JJJJJ");
        return supplierOrderService.searchByOrderId(orderId);
    }

    @GetMapping(value = "/searchsuporddelete/{orderId}")
    public SupplierOrderSearchDto searchById(@PathVariable int orderId){
        return supplierOrderService.searchOrderById(orderId);

    }

    @DeleteMapping(value = "/SupplierOrderDelete/{orderId}")
    public String deleteSupplierOrders(@PathVariable int orderId){
        return  supplierOrderService.deleteSupplierOrder(orderId);

    }

    @GetMapping(value = "/getMonthOrder")
    public List<SupplierOrderSearchDto> getAllOrders(){

        System.out.println("CONTROLLER MONTHE RECEIVED ORDER");
        return supplierOrderService.getAllOrders();
    }



    @PostMapping(value = "/SupOrdReportPrint")
    public String SupOrdReportPrint(@RequestBody ArrayList<SupplierOrderSearchDto> OrdPrint){

        ReceivedOrderReport l1 = new ReceivedOrderReport();
        l1.generateSupplierReceivedOrderPdf(OrdPrint);
        return "9";

    }

}
