package lk.whsars.service;

import lk.whsars.entity.Item;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);

    List<Item> getAllItems(String name);
}
