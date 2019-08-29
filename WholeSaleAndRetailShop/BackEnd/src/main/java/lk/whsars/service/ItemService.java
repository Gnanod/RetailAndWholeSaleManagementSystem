package lk.whsars.service;

import lk.whsars.entity.Item;
import lk.whsars.entity.Stock;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);

    List<Item> getAllItems(String name);

    Item getAllItemsByBarcode(String searchBarcode);


}
