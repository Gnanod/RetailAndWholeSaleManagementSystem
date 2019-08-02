package lk.whsars.service;

import lk.whsars.entity.Customer;

public interface CustomerService {
    static void deleteCustomer(String cusID) {
    }

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer searchByCustomerNIC(String nic);
}
