package lk.whsars.service.impl;

import lk.whsars.entity.Item;
import lk.whsars.entity.Supplier;
import lk.whsars.entity.SupplierOrder;
import lk.whsars.repository.SupplierRepositoryH;
import lk.whsars.service.SupplierServiceH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImplH implements SupplierServiceH {

    @Autowired
    private SupplierRepositoryH supplierRepositoryH;

    @Override
    public List<Supplier> getAllAgentsformCompany(String companyName) {

        List<Object[]> ob = supplierRepositoryH.getAllAgentsformCompany(companyName);

        List<Supplier> l1 = new ArrayList<>();
        for ( Object o[]: ob
        ) {

            Supplier s1 = new Supplier();
            s1.setSupplierName(o[0].toString());
            s1.setSupplierNic(o[1].toString());
            s1.setSupplierId(Integer.parseInt(o[2].toString()));
            l1.add(s1);

        }

        return l1;
    }

    @Override
    public List<Item> getAllItemsToCart(String nic) {

        List<Object[]> ob = supplierRepositoryH.getAllItemsToCart(nic);

        List<Item> i = new ArrayList<>();
        for ( Object o[]: ob
        ) {
            Item i1 = new Item();

            i1.setBarCode(o[0].toString());
            i1.setItemName(o[1].toString());
            i1.setRetailPrice(Double.parseDouble(o[2].toString()));



            i.add(i1);
        }


        return i;
    }
}
