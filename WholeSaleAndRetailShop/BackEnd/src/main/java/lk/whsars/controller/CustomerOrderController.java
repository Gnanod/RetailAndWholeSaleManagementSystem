package lk.whsars.controller;

import lk.whsars.entity.CustomerOrder;
import lk.whsars.entity.CustomerOrderDetail;
import lk.whsars.service.CustomerOrderDetailService;
import lk.whsars.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/CustomerOrderController")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;
    private CustomerOrderDetailService customerOrderDetailService;


    @PostMapping(value = "/addCustomerOrder")
    public String addCustomerOrder(@RequestBody CustomerOrder customerOrder){
        System.out.println(customerOrder);
        String s1 = customerOrderService.addCustomerOrder(customerOrder);

        if(s1!=null){
            return "99";
        }else{
            return null;
        }

    }

//    @PostMapping(value = "/addCustomerOrderDetail")
//    public CustomerOrderDetail addCustomerOrderDetail(@RequestBody CustomerOrderDetail customerOrderDetail){
//        System.out.println(customerOrderDetail);
//        return customerOrderDetailService.addCustomerOrderDetail(customerOrderDetail);
//    }

}
