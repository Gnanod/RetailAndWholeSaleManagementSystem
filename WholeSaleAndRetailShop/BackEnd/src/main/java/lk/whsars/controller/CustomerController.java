package lk.whsars.controller;


import lk.whsars.entity.Customer;
import lk.whsars.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/CustomerController")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    
    @PostMapping(value = "/updateCustomer")
    public Customer updateCutomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @GetMapping(value = "/searchByCustomerNIC/{NIC}")
    public Customer searchByCustomerNIC(@PathVariable String NIC ){
        System.out.println("Nic"+NIC);
        return customerService.searchByCustomerNIC(NIC);
    }

    @DeleteMapping("/deleteCustomer/{cusID}")
    void deleteCustomer(@PathVariable String cusID){
        customerService.deleteCustomer(cusID);
    }


    @GetMapping(value = "/searchByCustomerID/{phone}")
    public Customer searchByCustomerID(@PathVariable String phone ){
        System.out.println("cusID"+phone);
        return customerService.searchByCustomerID(phone);
    }

    @PostMapping(value = "/updateLoyaltyPoints")
    public Customer updateLoyaltyPoints(@RequestBody Customer customer){
        return customerService.updateLoyaltyPoints(customer);
    }
}
