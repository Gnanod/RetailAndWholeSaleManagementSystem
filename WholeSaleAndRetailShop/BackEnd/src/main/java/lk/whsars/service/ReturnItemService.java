package lk.whsars.service;

import lk.whsars.Common.ReturnItemListDTO;
import lk.whsars.entity.Item;
import lk.whsars.entity.ReturnItem;

import java.util.List;

public interface ReturnItemService {

    List<Item> getAllItems(int orderId);

    List<ReturnItemListDTO> searchByOrderId(int orderId);

    ReturnItem addItem(ReturnItem returnItem);

    List<ReturnItem> getAllReturnItem();

    List<ReturnItem> getAllReturnItems();

    ReturnItem UpdateReturnItem(ReturnItem returnItem);

    void deleteReturnEntry(String retItemId);
}
