package lk.whsars.service;

import lk.whsars.entity.Customer;

public interface CustomerService {
     void deleteCustomer(String cusID);


    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer searchByCustomerNIC(String nic);
}