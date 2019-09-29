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
import java.util.ArrayList;
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
            d1.setSupplierId(Integer.parseInt(sup[7].toString()));


        }

        return d1;
//        return supplierOrderRepository.searchByOrderId(orderId);
    }

    @Override
    public String deleteSupplierOrder(Integer orderId) {
        supplierOrderRepository.deleteById(orderId);
        return "0";
    }

    @Override
    public SupplierOrderSearchDto searchOrderById(Integer orderId) {

        List<Object []> s2 = supplierOrderRepository.searchSupOrderDelete(orderId);
        SupplierOrderSearchDto d1 = new SupplierOrderSearchDto();

        for (Object supOrd[]:s2){
            d1.setSupplierOrderId(supOrd[0].toString());
            d1.setCompanyName(supOrd[1].toString());
            d1.setSupplierName(supOrd[2].toString());
            d1.setDate(supOrd[3].toString());
            d1.setTotal(Double.parseDouble(supOrd[4].toString()));
            d1.setStatus(supOrd[5].toString());
        }

        return d1;
    }

    @Override
    public List<SupplierOrderSearchDto> getAllOrders() {
        List<Object[]> receivedord = supplierOrderRepository.receivedSupOrders();

        List<SupplierOrderSearchDto> d = new ArrayList<SupplierOrderSearchDto>();
        for ( Object ob []: receivedord
        ) {

            SupplierOrderSearchDto d1 = new SupplierOrderSearchDto();

            d1.setSupplierOrderId(ob[0].toString());
            d1.setSupplierId(Integer.parseInt(ob[1].toString()));
            d1.setCompanyName(ob[2].toString());
            d1.setSupplierName(ob[3].toString());
            d1.setDate(ob[4].toString());
            d1.setTotal(Double.parseDouble(ob[5].toString()));
            d1.setStatus(ob[6].toString());

            d.add(d1);

            System.out.println("PRINT IMPLE " + d1);

        }


        return d;
    }


}
