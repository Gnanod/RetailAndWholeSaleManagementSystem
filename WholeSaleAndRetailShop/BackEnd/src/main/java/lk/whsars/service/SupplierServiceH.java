package lk.whsars.service;

import lk.whsars.entity.Item;
import lk.whsars.entity.Supplier;
import lk.whsars.entity.SupplierOrder;

import java.util.List;

public interface SupplierServiceH {

    List<Supplier> getAllAgentsformCompany(String companyName);

    List<Item> getAllItemsToCart(String nic);



}
