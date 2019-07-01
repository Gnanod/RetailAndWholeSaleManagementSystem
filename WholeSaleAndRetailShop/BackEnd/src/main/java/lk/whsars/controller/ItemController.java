package lk.whsars.controller;

import lk.whsars.entity.Item;
import lk.whsars.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/ItemController")
public class ItemController {
    
   @Autowired
   private ItemService itemService;
   
   @PostMapping(value = "/AddItem")
   public Item addItem(@RequestBody Item item){
       
       return  itemService.addItem(item);
   }
    
}
