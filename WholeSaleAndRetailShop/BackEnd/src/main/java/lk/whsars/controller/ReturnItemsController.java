package lk.whsars.controller;

import lk.whsars.Common.ReturnItemListDTO;
import lk.whsars.entity.*;
import lk.whsars.service.CustomerOrderDetailService;
import lk.whsars.service.ReturnItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/ReturnItemController")
public class ReturnItemsController {

    @Autowired
    private ReturnItemService returnItemService;


    @GetMapping(value = "/searchByOrderId/{orderId}")
    public List<ReturnItemListDTO> searchByOrderId(@PathVariable int orderId ){
        System.out.println("orderid"+orderId);
        return returnItemService.searchByOrderId(orderId);
    }

    @PostMapping(value = "/addReturnedItem")
    public ReturnItem addItem(@RequestBody ReturnItem returnItem){
        return  returnItemService.addItem(returnItem);
    }

//    @GetMapping(value = "/getAllReturnItems")
//    public List<ReturnItem> getAllEmployee(){
//        System.out.println("weda karanawada?");
//        List<ReturnItem> l1 = returnItemService.getAllReturnItem();
//        for (ReturnItem: l1 ) {
//            System.out.println();
//        }
//        return l1;
//    }

    @GetMapping(value = "/getAllReturnItem")
    public List<ReturnItem> getAllReturnItems(){

        return  returnItemService.getAllReturnItems();

    }


    @PostMapping(value = "/updateReturnItem")
    public ReturnItem UpdateReturnItem(@RequestBody ReturnItem returnItem){

        return returnItemService.UpdateReturnItem(returnItem);

    }

    @DeleteMapping("/deleteReturnEntry/{retItemId}")
    void deleteEmployee(@PathVariable String retItemId) {
        returnItemService.deleteReturnEntry(retItemId);
    }

}
