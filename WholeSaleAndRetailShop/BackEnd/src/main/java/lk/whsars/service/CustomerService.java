package lk.whsars.service;

import lk.whsars.DTO.CustomerRDto;
import lk.whsars.entity.Customer;

import java.util.List;

public interface CustomerService {
     void deleteCustomer(String cusID);


    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer searchByCustomerNIC(String nic);

    Customer searchByCustomerID(String phone);

    Customer updateLoyaltyPoints(Customer customer);


    List<CustomerRDto> getCusDetail();
}
