package lk.whsars.service.impl;

import lk.whsars.entity.Supplier;
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

            s1.setSuppliername(o[0].toString());

            System.out.println("KKKK"+s1.getSuppliername());
            l1.add(s1);
        }

        return l1;
    }
}
