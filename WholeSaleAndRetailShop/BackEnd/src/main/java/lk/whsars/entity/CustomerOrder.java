package lk.whsars.entity;
import org.springframework.format.datetime.standard.DateTimeContext;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Entity
public class CustomerOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerOrderId;

    private LocalDateTime date;
    private double totalPrice;
    private double discount;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customerOrder")
    private Set<CustomerOrderDetail> customerOrderDetailSet;

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<CustomerOrderDetail> getCustomerOrderDetailSet() {

        return customerOrderDetailSet;

    }

    public void setCustomerOrderDetailSet(Set<CustomerOrderDetail> customerOrderDetailSet) {
        for (CustomerOrderDetail c :customerOrderDetailSet
             ) {

            c.setCustomerOrder(this);

        }
        this.customerOrderDetailSet = customerOrderDetailSet;
    }
}