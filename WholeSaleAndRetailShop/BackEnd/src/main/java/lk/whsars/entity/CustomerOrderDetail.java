package lk.whsars.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
    public class CustomerOrderDetail {
        @Id
        private int customerOrderDetail;
        private double  amount;
        private double discount;
        @ManyToOne
//        @OnDelete(action = OnDeleteAction.CASCADE)
        private CustomerOrder customerOrder;
        @ManyToOne
        @OnDelete(action = OnDeleteAction.CASCADE)
        private Item item;



    }
