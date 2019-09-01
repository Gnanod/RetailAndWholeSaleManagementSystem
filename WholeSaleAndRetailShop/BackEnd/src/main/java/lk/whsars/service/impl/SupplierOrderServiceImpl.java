package lk.whsars.service.impl;

import lk.whsars.entity.Company;
import lk.whsars.entity.SupplierOrder;
import lk.whsars.repository.CompanyRepoH;
import lk.whsars.repository.SupplierOrderRepository;
import lk.whsars.service.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierOrderServiceImpl implements SupplierOrderService {

    @Autowired
    private SupplierOrderRepository supplierOrderRepository;
    @Autowired
    private CompanyRepoH companyRepoH;


    @Override
    public SupplierOrder addSupplierOrder(SupplierOrder supplierOrder){

        return  supplierOrderRepository.save(supplierOrder);
    }

    @Override
    public SupplierOrder updateSupplierOrder(SupplierOrder supplierOrder){

        return supplierOrderRepository.save(supplierOrder);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepoH.findAll();
    }



}
