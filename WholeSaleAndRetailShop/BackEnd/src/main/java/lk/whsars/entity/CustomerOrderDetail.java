package lk.whsars.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
    public class CustomerOrderDetail {
        @Id
        private int cusOrderDetailId;
        private String itemCode;
        private String itemName;
        private String brand;
        private double itemPrice;
        private int qty;
        private double  amount;
        @ManyToOne
//        @OnDelete(action = OnDeleteAction.CASCADE)
        private CustomerOrder customerOrder;
        @ManyToOne
        @OnDelete(action = OnDeleteAction.CASCADE)
        private Item item;


    public int getCusOrderDetailId() {
        return cusOrderDetailId;
    }

    public void setCusOrderDetailId(int cusOrderDetailId) {
        this.cusOrderDetailId = cusOrderDetailId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
