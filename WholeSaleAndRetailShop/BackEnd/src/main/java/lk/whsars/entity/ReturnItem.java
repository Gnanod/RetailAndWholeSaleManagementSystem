package lk.whsars.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ReturnItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int retItemId;
    private String retItemBarcode;
    private String retDate;
    private String retItemName;
    private int retQuant;
    private int resellableQuant;
    private int notresellableQuant;

//    @ManyToOne
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(nullable = false)
//    private CustomerOrder customerOrder;

    public String getRetDate() {
        return retDate;
    }

    public void setRetDate(String retDate) {
        this.retDate = retDate;
    }
//
//    public CustomerOrder getCustomerOrder() {
//        return customerOrder;
//    }
//
//    public void setCustomerOrder(CustomerOrder customerOrder) {
//        this.customerOrder = customerOrder;
//    }

    public int getRetItemId() {
        return retItemId;
    }

    public void setRetItemId(int retItemId) {
        this.retItemId = retItemId;
    }

    public int getRetQuant() {
        return retQuant;
    }

    public void setRetQuant(int retQuant) {
        this.retQuant = retQuant;
    }

    public int getResellableQuant() {
        return resellableQuant;
    }

    public void setResellableQuant(int resellableQuant) {
        this.resellableQuant = resellableQuant;
    }

    public int getNotresellableQuant() {
        return notresellableQuant;
    }

    public void setNotresellableQuant(int notresellableQuant) {
        this.notresellableQuant = notresellableQuant;
    }

    public String getRetItemBarcode() {
        return retItemBarcode;
    }

    public void setRetItemBarcode(String retItemBarcode) {
        this.retItemBarcode = retItemBarcode;
    }

    public String getRetItemName() {
        return retItemName;
    }

    public void setRetItemName(String retItemName) {
        this.retItemName = retItemName;
    }



}
