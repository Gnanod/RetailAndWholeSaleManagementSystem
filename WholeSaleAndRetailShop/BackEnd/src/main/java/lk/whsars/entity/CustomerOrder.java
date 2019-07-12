package lk.whsars.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerOrder {
    
    @Id
    int customerOrderId;
    String date;
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
}
