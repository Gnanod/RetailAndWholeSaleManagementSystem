package lk.whsars.controller;

import lk.whsars.entity.CustomerOrder;
import lk.whsars.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/CustomerOrderController")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping(value = "/addCustomerOrder")
    public CustomerOrder addCustomerOrder(@RequestBody CustomerOrder customerOrder){
        return customerOrderService.addCustomerOrder(customerOrder);
    }
}
