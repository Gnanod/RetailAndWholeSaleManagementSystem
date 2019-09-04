package lk.whsars.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerOrderDetail {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int customerOrderDetailId;

        @ManyToOne
        @OnDelete(action = OnDeleteAction.CASCADE)
        private CustomerOrder customerOrder;

        @ManyToOne
        @OnDelete(action = OnDeleteAction.CASCADE)
        private Item item;

        private int qty;
        private double price;


    public double getPrice() {  return price;}

    public void setPrice(double price) {  this.price = price;}

    public int getQty() { return qty;}

    public void setQty(int qty) { this.qty = qty;}

    public int getCustomerOrderDetailId() {
        return customerOrderDetailId;
    }

    public void setCustomerOrderDetailId(int customerOrderDetailId) {
        this.customerOrderDetailId = customerOrderDetailId;
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
