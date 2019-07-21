package lk.whsars.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerOrderId;
    private String date;
    private double totalAmount;
    private double discount;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;
   @OneToMany(cascade = CascadeType.ALL,mappedBy = "customerOrder")
    private Set<CustomerOrderDetail> customerOrderDetailSet;

    public int getCustomerOrderId() {
        return customerOrderId;
    }


    public Set<CustomerOrderDetail> getCustomerOrderDetailSet() {
        return customerOrderDetailSet;
    }

    public void setCustomerOrderDetailSet(Set<CustomerOrderDetail> customerOrderDetailSet) {
        this.customerOrderDetailSet = customerOrderDetailSet;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
