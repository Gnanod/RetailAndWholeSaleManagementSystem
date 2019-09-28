package lk.whsars.DTO;


import lk.whsars.entity.Customer;
import lk.whsars.entity.CustomerOrderDetail;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Date;

public class CustomerLastOrderDto {

    private int customerOrderId;
    private double totalPrice;
    private double discount;

    private Date date;
    Customer customer;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customerOrder")
    CustomerOrderDetail customerOrderDetailSet;

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerOrderDetail getCustomerOrderDetailSet() {
        return customerOrderDetailSet;
    }

    public void setCustomerOrderDetailSet(CustomerOrderDetail customerOrderDetailSet) {
        this.customerOrderDetailSet = customerOrderDetailSet;
    }
}
