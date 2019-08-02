package lk.whsars.service.impl;

import lk.whsars.entity.Customer;
import lk.whsars.repository.CustomerRepository;
import lk.whsars.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer) ;
    }

    @Override
    public Customer searchByCustomerNIC(String nic) {
        return customerRepository.searchByCustomerDetailsByNIC(nic);
    }




}
