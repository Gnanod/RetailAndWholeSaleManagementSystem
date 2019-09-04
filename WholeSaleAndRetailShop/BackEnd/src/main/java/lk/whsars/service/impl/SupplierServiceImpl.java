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

    public List<Supplier>getAllSupplier(){
        return supplierRepository.findAll();
    }

    @Override
    public Supplier addSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }


    @Override
    public Supplier searchBySupplierNic(String supplierNic){
        return supplierRepository.searchBySupplierNic(supplierNic);
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(Supplier supplierNic) {

        System.out.println("NIC"+supplierNic);
        supplierRepository.delete(supplierNic);
        // supplierRepository.deleteSupplier(supplierNic);


    }

    @Override
    public String deleteSuppliers(String supplierNic) {

        Object ob = supplierRepository.deleteSupplier(supplierNic);

        if(ob !=null){

            return "9";

        }else{

            return null;

        }
    }

    @Override
    public String deleteSup(int supplierNic) {
        System.out.println("tttttttt"+supplierNic);
        supplierRepository.deleteById(supplierNic);
        return "9";
    }
}
