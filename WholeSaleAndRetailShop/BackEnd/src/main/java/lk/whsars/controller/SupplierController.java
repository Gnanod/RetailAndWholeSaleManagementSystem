package lk.whsars.controller;

//
//
//@CrossOrigin
//@RestController
//@RequestMapping(value = "/supplierController")
//public class SupplierController {
//
//    @Autowired
//    private SupplierService supplierService;
//
//
//    @PostMapping(value = "/addSupplier")
//    public Supplier addSupplier(@RequestBody Supplier supplier){
//        return supplierService.addSupplier(supplier);
//    }
//
//
//    @GetMapping(value = "/getAllSupplier")
//    public List<Supplier> getAllSupplier(){
//        return supplierService.getAllSupplier();
//    }
//
//    @GetMapping(value = "/searchBySupplierNic/{supplierNic}")
//    public Supplier searchBySupplierNic(@PathVariable String supplierNic){
//        return supplierService.searchBySupplierNic(supplierNic);
//    }
//
//    @PostMapping( "/updateSupplierDetails")
//    public Supplier updateSupplierDetails(@RequestBody Supplier supplier){
//        return supplierService.updateSupplier(supplier);
//    }
//
////    @DeleteMapping("/deleteSupplier/{supplierNic}")
////     String deleteSupplier(@PathVariable Supplier supplierNic){
////        System.out.println("8888ß");
////        supplierService.deleteSupplier(supplierNic);
////        return "9";
////    }
//        @DeleteMapping("/deleteSupplier/{supplierNic}")
//        String deleteSupplier(@PathVariable int supplierNic){
//            System.out.println("8888ß");
//            String value = supplierService.deleteSup(supplierNic);
//
//            return "9";
//        }
//
//
//}



import lk.whsars.Common.SupplierReport;
import lk.whsars.DTO.SupplierDetailsDto;
import lk.whsars.entity.Company;
import lk.whsars.entity.Supplier;
import lk.whsars.service.CompanyService;
import lk.whsars.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/supplierController")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    private CompanyService companyService;


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



    @GetMapping(value ="/getCompany")
    public List<Company> getAllCompany(){

        return supplierService.getAllCompany();

    }
//    @GetMapping(value = "/searchByCompanyName/{companyName}")
//    public Company searchByCompanyName(@PathVariable String companyName){
//        System.out.println("GGGGGGGGGGGGGGG");
//        return companyService.searchByCompanyName(companyName);
//    }

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

    @GetMapping(value = "/getSupplierReport")
    public List<SupplierDetailsDto> getSuplliers(){

        return supplierService.getSuppliersReport();

    }


    @PostMapping(value = "/printReport")
    public String printReport(@RequestBody ArrayList<SupplierDetailsDto> SupplierDetailsDto){

        SupplierReport s1 = new   SupplierReport();
        s1.generateSupplierReportPdf(SupplierDetailsDto);
        return "9";

    }


}
