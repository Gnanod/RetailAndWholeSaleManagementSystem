package lk.whsars.service.impl;

import lk.whsars.DTO.SupplierOrderSearchDto;
import lk.whsars.entity.Company;
import lk.whsars.entity.SupplierOrder;
import lk.whsars.repository.CompanyRepoH;
import lk.whsars.repository.SupplierOrderRepository;
import lk.whsars.service.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public String updateSupplierOrder(SupplierOrder supplierOrder){

        Object ob = supplierOrderRepository.save(supplierOrder);

        if(ob !=null){
            return "9";
        }else{
            return null;
        }
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepoH.findAll();
    }

    @Override
    @Transactional
    public SupplierOrder addSupplierOrderToDb(SupplierOrder supplierOrder) {

        return supplierOrderRepository.save(supplierOrder);

    }

    @Override
    public SupplierOrderSearchDto searchByOrderId(Integer orderId){

       List<Object []> s1 = supplierOrderRepository.searchSupplierOrder(orderId);

       SupplierOrderSearchDto d1 = new SupplierOrderSearchDto();

        for (Object sup[]: s1
             ) {
            d1.setCompanyName(sup[0].toString());
            d1.setDate(sup[1].toString());
            d1.setSupplierName(sup[2].toString());
            d1.setStatus(sup[3].toString());
            System.out.println("OOOOO"+sup[4].toString());
           d1.setTotal(Double.parseDouble( sup[4].toString()));
            d1.setSupplierOrderId(sup[5].toString());
            d1.setSupplierNIC(sup[6].toString());
        }

        return d1;
//        return supplierOrderRepository.searchByOrderId(orderId);
    }


}
