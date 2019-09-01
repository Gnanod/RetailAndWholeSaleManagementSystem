package lk.whsars.service.impl;

import lk.whsars.entity.Supplier;
import lk.whsars.repository.SupplierRepository;
import lk.whsars.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;


    @Override
    public List<Supplier> getAgentBySupplier(String agentName) {
        return null;
    }
}
