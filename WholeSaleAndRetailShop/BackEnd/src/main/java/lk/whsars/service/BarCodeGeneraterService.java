package lk.whsars.service;

import lk.whsars.entity.Brand;
import lk.whsars.entity.Item;

import java.util.List;

public interface BarCodeGeneraterService {

    List<Item> getAllItems();

    Item getBarcodeNumbers(String itemName);
}
