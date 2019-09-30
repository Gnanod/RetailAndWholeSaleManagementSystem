package lk.whsars.service.impl;

import lk.whsars.DTO.CustomerRDto;
import lk.whsars.entity.Customer;
import lk.whsars.repository.CustomerRepository;
import lk.whsars.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void deleteCustomer(String cusID) {

        customerRepository.deleteById(Integer.parseInt(cusID));
    }

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

    @Override
    public Customer searchByCustomerID(String phone) { return customerRepository.searchByCustomerDetailsByID(phone); }

    @Override
    public Customer updateLoyaltyPoints(Customer customer) { return customerRepository.save(customer); }

    @Override
    public List<CustomerRDto> getCusDetail() {

        List<Object[]> cusR = customerRepository.getCusRDetails();

        List<CustomerRDto> c = new ArrayList<CustomerRDto>();
        for ( Object ob []: cusR
        ) {

            CustomerRDto c1 = new CustomerRDto();

            c1.setUserName(ob[0].toString());
            c1.setNic(ob[1].toString());
            c1.setEmail(ob[2].toString());
            c1.setType(ob[3].toString());
            c1.setLoyaltyPoints(Integer.parseInt(ob[4].toString()));


            c.add(c1);

        }

        return c;

    }


}
