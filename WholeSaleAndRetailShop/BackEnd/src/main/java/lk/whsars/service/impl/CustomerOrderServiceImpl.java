package lk.whsars.service.impl;

import lk.whsars.DTO.CustomerLastOrderDto;
import lk.whsars.DTO.CustomerOrderReportDTO;
import lk.whsars.entity.CustomerOrder;
import lk.whsars.entity.CustomerOrderDetail;
import lk.whsars.entity.Item;
import lk.whsars.repository.CustomerOrderDetailRepository;
import lk.whsars.repository.CustomerOrderRepository;
import lk.whsars.repository.ItemRepository;
import lk.whsars.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CustomerOrderDetailRepository customerOrderDetailRepository;

    @Override
    @Transactional
    public String addCustomerOrder(CustomerOrder customerOrder) {
        System.out.println(customerOrder);

        CustomerOrder c1 = customerOrderRepository.save(customerOrder);

        if (c1 != null) {
            Set<CustomerOrderDetail> stockItemDetails = customerOrder.getCustomerOrderDetailSet();
            for (CustomerOrderDetail s2 : stockItemDetails) {
                Item i = s2.getItem();
                i.getItemQtyOnHand();
                itemRepository.save(i);
            }
            return "99";

        } else {
            return null;
        }
    }


    @Override
    public List<Item> getAllItemsForCounter(String nameOrId) {
        List<Item> item = customerOrderRepository.findAllItemsByNameOrId(nameOrId);
        if (item.size() != 0) {
            return item;
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getAllItems(String searchName) {
        List<Item> item = customerOrderRepository.getAllItems(searchName);
        if (item.size() != 0) {
            return item;
        } else {
            return null;
        }
    }


    @Override
    public List<CustomerOrderDetail> getAllOrderItems(int searchOrder) {
        List<CustomerOrderDetail> order = customerOrderDetailRepository.getAllOrderItems(searchOrder);
        System.out.println(order);
        if (order.size() != 0) {
            return order;
        } else {
            return null;
        }
    }

    @Override
    public CustomerLastOrderDto getCustomerLastOrder() {
        List<Object[]> lastOrder = customerOrderRepository.getLastOrder();

        CustomerLastOrderDto CLO = new CustomerLastOrderDto();
        for (Object[] sup : lastOrder) {

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


    @Override
    public List<CustomerOrderReportDTO> getCustomerOrderReport() {

        List<Object[]> customerOrderReport = customerOrderRepository.getCustomerOrderReport();
        List<CustomerOrderReportDTO> C = new ArrayList<CustomerOrderReportDTO>();

        for (Object[] ob : customerOrderReport) {
            CustomerOrderReportDTO c1 = new CustomerOrderReportDTO();
            c1.setCustomerOrderId(Integer.parseInt(ob[0].toString()));
            c1.setTotalPrice(Double.parseDouble(ob[1].toString()));
            c1.setDiscount(Double.parseDouble(ob[2].toString()));
            c1.setCustomerId(Integer.parseInt(ob[3].toString()));
            c1.setPhone(ob[4].toString());

            C.add(c1);
        }
        return C;
    }

}
