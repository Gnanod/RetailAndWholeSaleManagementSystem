package lk.whsars.service;

import lk.whsars.entity.CustomerOrder;
import lk.whsars.entity.Item;

import java.util.List;

public interface CustomerOrderService {

    String addCustomerOrder(CustomerOrder customerOrder);

    List<Item> getAllItemsForCounter(String nameOrId);

    List<Item> getAllItems(String searchName);


//  List<Item> getAllItems(String name);

}
