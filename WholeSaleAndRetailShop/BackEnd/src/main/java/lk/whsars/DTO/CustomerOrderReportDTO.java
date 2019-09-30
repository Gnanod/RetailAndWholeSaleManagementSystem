package lk.whsars.DTO;

import lk.whsars.entity.Customer;

import java.util.Date;

public class CustomerOrderReportDTO {

    private int customerOrderId;
    private double totalPrice;
    private double discount;
    private int customerId;
    String phone;
    private Date date;
    Customer customer;

    public CustomerOrderReportDTO() {
    }

    public CustomerOrderReportDTO(int customerOrderId, double totalPrice, double discount, int customerId, Date date, Customer customer) {
        this.customerOrderId = customerOrderId;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.customerId = customerId;
        this.date = date;
        this.customer = customer;
    }

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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
