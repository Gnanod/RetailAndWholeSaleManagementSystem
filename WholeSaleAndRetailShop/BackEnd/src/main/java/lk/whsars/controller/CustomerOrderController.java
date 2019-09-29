package lk.whsars.controller;

import lk.whsars.DTO.CustomerLastOrderDto;
import lk.whsars.entity.Customer;
import lk.whsars.entity.CustomerOrder;
import lk.whsars.entity.CustomerOrderDetail;
import lk.whsars.entity.Item;
import lk.whsars.service.CustomerOrderDetailService;
import lk.whsars.service.CustomerOrderService;
import lk.whsars.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/CustomerOrderController")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private ItemService itemService;


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


    @GetMapping(value = "/searchItemDetailsByNameOrId/{searchNameOrId}")
    public List<Item> getAllItemsForCounter(@PathVariable String searchNameOrId){
        System.out.println("PathVarialble"+searchNameOrId);
        if(searchNameOrId!=null){
            return customerOrderService.getAllItemsForCounter(searchNameOrId);
        }else{
            return  null;
        }
    }

//    @PostMapping(value = "/addCustomerOrderDetail")
//    public CustomerOrderDetail addCustomerOrderDetail(@RequestBody CustomerOrderDetail customerOrderDetail){
//        System.out.println(customerOrderDetail);
//        return customerOrderDetailService.addCustomerOrderDetail(customerOrderDetail);
//    }

    @GetMapping(value = "/searchItemDetailsByBarcode/{searchName}")
    public List<Item> getItemDetails(@PathVariable String searchName){
        System.out.println("PathVarialble"+searchName);
        if(searchName!=null){
            return customerOrderService.getAllItems(searchName);
        }else{
            return  null;
        }
    }



    @GetMapping(value = "/searchLastOrder")
    public CustomerLastOrderDto getLastOrder(){
        return customerOrderService.getCustomerLastOrder();
    }



    @DeleteMapping("/deleteCustomerOrder/{lastOrderId}")
    void lastOrderUndo(@PathVariable int lastOrderId) {
        System.out.println("Last order id  "+lastOrderId);
        customerOrderService.lastOrderUndo(lastOrderId);
    }

//    @PostMapping(value = "/updateLoyaltyPoints")
//    public Customer updateLoyaltyPoints(@RequestBody Customer customer){
//        return customerOrderService.updateCustomer(customer);
//    }


}
