package lk.whsars.service.impl;

import lk.whsars.entity.CustomerOrder;
import lk.whsars.entity.CustomerOrderDetail;
import lk.whsars.entity.Item;
import lk.whsars.entity.StockItemDetails;
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
            for (CustomerOrderDetail s2: stockItemDetails
            ) {

                Item i = s2.getItem();
                itemRepository.save(i);

            }
            return "9";

        }else{
            return null;
        }

    }


//    @Override
//    public List<Item> getAllItems(String name) {
//        List<Item> item= customerOrderRepository.findAllItemsByName(name);
//        if(item.size()!=0){
//            return item;
//        }else{
//            return null;
//        }
//    }

}
