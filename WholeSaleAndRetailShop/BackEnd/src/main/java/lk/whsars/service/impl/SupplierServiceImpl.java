package lk.whsars.service.impl;

import lk.whsars.DTO.SupplierDetailsDto;
import lk.whsars.entity.Company;
import lk.whsars.entity.Supplier;
import lk.whsars.repository.CompanyRepository;
import lk.whsars.repository.SupplierRepository;
import lk.whsars.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private CompanyRepository companyRepository;


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

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();

    }


    @Override
    public List<SupplierDetailsDto> getSuppliersReport() {
        List<Object[]> suppl = supplierRepository.getSupplierDetailsReport();

        List<SupplierDetailsDto> s = new ArrayList<SupplierDetailsDto>();
        for (Object ob [] : suppl ){

            SupplierDetailsDto s1 = new SupplierDetailsDto();

            s1.setSupplierName(ob[0].toString());
            s1.setSupplierNic(ob[1].toString());
            s1.setAddress(ob[2].toString());
            s1.setEmail(ob[3].toString());
            s1.setPhone(ob[4].toString());
            s1.setDate(ob[5].toString());
            // s1.setCompany(ob[6].toString());
            //s1.setCompany(ob[6].toString());

            s.add(s1);

        }
        return s;
    }

}
