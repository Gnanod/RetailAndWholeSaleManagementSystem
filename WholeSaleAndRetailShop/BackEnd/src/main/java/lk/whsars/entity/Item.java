package lk.whsars.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {

    @Id
    private String barCode;
    private String itemName;
    private double itemQtyOnHand;
    private double wholeSalePrice;
    private double retailPrice;
    
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Brand brand;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "item")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<CustomerOrderDetail> customerOrderDetails;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "item")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<SupplierOrderDetail> supplierOrderDetails;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "item")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<StockItemDetails> stockItemDetails;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemQtyOnHand() {
        return itemQtyOnHand;
    }

    public void setItemQtyOnHand(double itemQtyOnHand) {
        this.itemQtyOnHand = itemQtyOnHand;
    }

    public double getWholeSalePrice() {
        return wholeSalePrice;
    }

    public void setWholeSalePrice(double wholeSalePrice) {
        this.wholeSalePrice = wholeSalePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<CustomerOrderDetail> getCustomerOrderDetails() {
        return customerOrderDetails;
    }

    public void setCustomerOrderDetails(Set<CustomerOrderDetail> customerOrderDetails) {
        this.customerOrderDetails = customerOrderDetails;
    }

    public Set<SupplierOrderDetail> getSupplierOrderDetails() {
        return supplierOrderDetails;
    }

    public void setSupplierOrderDetails(Set<SupplierOrderDetail> supplierOrderDetails) {
        this.supplierOrderDetails = supplierOrderDetails;
    }

    public Set<StockItemDetails> getStockItemDetails() {
        return stockItemDetails;
    }

    public void setStockItemDetails(Set<StockItemDetails> stockItemDetails) {
        this.stockItemDetails = stockItemDetails;
    }
}
