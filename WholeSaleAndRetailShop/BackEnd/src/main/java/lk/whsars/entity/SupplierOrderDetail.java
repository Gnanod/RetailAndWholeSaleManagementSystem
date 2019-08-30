package lk.whsars.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SupplierOrderDetail {
    @Id
    int supplierOrderId;
    int quantity;


    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SupplierOrder  supplierOrder;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Item item;
    
    
}
