package lk.whsars.service;

import lk.whsars.entity.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lk.whsars.entity.Stock;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);

    List<Item> getAllItems(String name);

    Item getAllItemsByBarcode(String searchBarcode);


}
