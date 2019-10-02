package lk.whsars.service.impl;

import lk.whsars.entity.CustomerOrderDetail;

import lk.whsars.repository.CustomerOrderDetailRepository;
import lk.whsars.service.CustomerOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class CustomerOrderDetailServiceImpl implements CustomerOrderDetailService {

    @Autowired
    private CustomerOrderDetailRepository customerOrderDetailRepository;


    public CustomerOrderDetail addCustomerOrderdetails(CustomerOrderDetail customerOrder) {
        return null;
    }

    @Autowired
    public List<CustomerOrderDetail> getAllCustomerOrderDetails(String name) {

        List<CustomerOrderDetail> CusOrderDetail= CustomerOrderDetailRepository.findAllCustomerOrderDetails(name);

        if(CusOrderDetail.size()!=0){
            return CusOrderDetail;

        }else{

            return null;

        }
    }

    @Override
    @Transactional
    public CustomerOrderDetail addCustomerOrderDetail(CustomerOrderDetail customerOrderDetail) {
        System.out.println(customerOrderDetail);
        return customerOrderDetailRepository.save(customerOrderDetail);
    }

}
