package lk.whsars.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SupplierOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int supplierOrderId;
    int companyName;
    int supplierId;
    String productName;
    int quantity;
    double amount;
    double total;
    String status;


    @ManyToOne
    private Supplier supplier;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "supplierOrder")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SupplierOrderDetail> supplierOrderDetails;
//    


    public int getSupplierOrderId() {
        return supplierOrderId;
    }

    public void setSupplierOrderId(int supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getAgentid() {
        return companyName;
    }

    public void setAgentid(int agentid) {
        this.companyName = agentid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
