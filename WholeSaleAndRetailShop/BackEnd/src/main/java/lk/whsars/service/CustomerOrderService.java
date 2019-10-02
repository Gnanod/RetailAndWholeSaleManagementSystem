package lk.whsars.service;

import lk.whsars.DTO.CustomerLastOrderDto;
import lk.whsars.DTO.CustomerOrderReportDTO;
import lk.whsars.entity.CustomerOrder;
import lk.whsars.entity.CustomerOrderDetail;
import lk.whsars.entity.Item;

import java.util.List;

public interface CustomerOrderService {

    String addCustomerOrder(CustomerOrder customerOrder);

    List<Item> getAllItemsForCounter(String nameOrId);

    List<Item> getAllItems(String searchName);

    List<CustomerOrderDetail> getAllOrderItems(int searchOrder);

    CustomerLastOrderDto getCustomerLastOrder();

    void lastOrderUndo(int customerOrderId);

    List<CustomerOrderReportDTO> getCustomerOrderReport();

}
