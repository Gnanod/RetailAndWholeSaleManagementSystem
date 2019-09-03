package lk.whsars.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class SupplierOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int supplierOrderId;
    int quantity;
    double price;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SupplierOrder  supplierOrder;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Item item;

    public int getSupplierOrderId() {
        return supplierOrderId;
    }

    public void setSupplierOrderId(int supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SupplierOrder getSupplierOrder() {
        return supplierOrder;
    }

    public void setSupplierOrder(SupplierOrder supplierOrder) {
        this.supplierOrder = supplierOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
