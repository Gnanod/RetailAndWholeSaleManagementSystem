package lk.whsars.service.impl;

import lk.whsars.entity.Item;
import lk.whsars.repository.ItemRepository;
import lk.whsars.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Override
    public Item addItem(Item item) {
        
        return itemRepository.save(item);
        
    }

    @Override
    public List<Item> getAllItems(String name) {

        List<Item> item= itemRepository.findAllItemsByName(name);
       
       if(item.size()!=0){
           return item;
           
       }else{
           
           return null;
           
       }
    }
}
