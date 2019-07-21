package lk.whsars.service.impl;

import lk.whsars.entity.CustomerOrder;
import lk.whsars.repository.CustomerOrderRepository;
import lk.whsars.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
        return null;
    }
}
