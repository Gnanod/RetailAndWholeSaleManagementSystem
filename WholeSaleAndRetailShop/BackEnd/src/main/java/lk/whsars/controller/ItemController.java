package lk.whsars.controller;

import lk.whsars.entity.IdEntity;
import lk.whsars.entity.Item;
import lk.whsars.entity.Stock;
import lk.whsars.service.IdService;
import lk.whsars.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/ItemController")
public class ItemController {
    
   @Autowired
   private ItemService itemService;
   @Autowired
   private IdService idService;
   @Autowired
   private IdController idController;
   
   @PostMapping(value = "/AddItem")
   public Item addItem(@RequestBody Item item){

      String lastId = idController.getLastID();
      Item pItem = item;
      pItem.setBarCode(lastId);
       
      return  itemService.addItem(item);
   }
   
   @GetMapping(value = "/searchItemDetailsByName/{searchName}")
   public List<Item> getItemDetails(@PathVariable String searchName){
      System.out.println("PathVarialble"+searchName);
      if(searchName!=null){
         return itemService.getAllItems(searchName);
      }else{
         return  null;
      }
   }


   @GetMapping(value = "/searchItemDetailsByBarcode/{searchBarcode}")
   public Item getItemDetailsByBarcode(@PathVariable String searchBarcode){
      if(searchBarcode!=null){
         return itemService.getAllItemsByBarcode(searchBarcode);
      }else{
         return  null;
      }

   }


    
}
