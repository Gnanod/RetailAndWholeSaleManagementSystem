package lk.whsars.DTO;

import java.util.Date;

public class CustomerOrderBillDto {

    private int customerOrderId;
    private double totalPrice;
    private double discount;
//    private int customerId;
//    private String itemName;
//    private int quentity;
//    private double itemTotPrice;
//    private Date date;

    public CustomerOrderBillDto() {
    }

    public CustomerOrderBillDto(int customerOrderId, double totalPrice, double discount, int customerId, String itemName, int quentity, double itemTotPrice, Date date) {
        this.customerOrderId = customerOrderId;
        this.totalPrice = totalPrice;
        this.discount = discount;
//        this.customerId = customerId;
//        this.itemName = itemName;
//        this.quentity = quentity;
//        this.itemTotPrice = itemTotPrice;
//        this.date = date;
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

//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getItemName() {
//        return itemName;
//    }
//
//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//
//    public int getQuentity() {
//        return quentity;
//    }
//
//    public void setQuentity(int quentity) {
//        this.quentity = quentity;
//    }
//
//    public double getItemTotPrice() {
//        return itemTotPrice;
//    }
//
//    public void setItemTotPrice(double itemTotPrice) {
//        this.itemTotPrice = itemTotPrice;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
}
