package lk.whsars.service.impl;

import lk.whsars.DTO.CustomerLastOrderDto;
import lk.whsars.entity.*;
import lk.whsars.repository.CustomerOrderRepository;
import lk.whsars.repository.ItemRepository;
import lk.whsars.service.CustomerOrderService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public String addCustomerOrder(CustomerOrder customerOrder) {
        System.out.println(customerOrder);

        CustomerOrder c1 = customerOrderRepository.save(customerOrder);

        if(c1!=null){
            Set<CustomerOrderDetail> stockItemDetails = customerOrder.getCustomerOrderDetailSet();
            for (CustomerOrderDetail s2: stockItemDetails)
            {
                Item i = s2.getItem();
                i.getItemQtyOnHand();
                itemRepository.save(i);
            }
            return "99";

        }else{
            return null;
        }

    }

    @Override
    public List<Item> getAllItemsForCounter(String nameOrId) {
        ;
        List<Item> item= customerOrderRepository.findAllItemsByNameOrId(nameOrId);
        if(item.size()!=0){
            return item;

        }else{

            return null;

        }
    }

    @Override
    public List<Item> getAllItems(String searchName) {

        List<Item> item = customerOrderRepository.getAllItems(searchName);
        if(item.size()!=0){

            return item;

        }else{

            return null;

        }

    }

    @Override
    public CustomerLastOrderDto getCustomerLastOrder() {

        List<Object []> lastOrder = customerOrderRepository.getLastOrder();

        CustomerLastOrderDto CLO = new CustomerLastOrderDto();
        for (Object sup[]: lastOrder) {

            CLO.setCustomerOrderId(Integer.parseInt(sup[0].toString()));
            CLO.setDiscount(Double.parseDouble(sup[1].toString()));
            CLO.setTotalPrice(Double.parseDouble(sup[2].toString()));

            CLO.setDate(null);
            CLO.setCustomerOrderDetailSet(null);
            CLO.setCustomer(null);
        }

        return CLO;

    }

    @Override
    public void lastOrderUndo(int customerOrderId) {
        customerOrderRepository.deleteById(customerOrderId);
    }



}
