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
    String companyName;
    double total;
    String status;
    String date;

    @ManyToOne
    private Supplier supplier;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "supplierOrder")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SupplierOrderDetail> supplierOrderDetails;

    public int getSupplierOrderId() {
        return supplierOrderId;
    }

    public void setSupplierOrderId(int supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<SupplierOrderDetail> getSupplierOrderDetails() {
        return supplierOrderDetails;
    }

    public void setSupplierOrderDetails(Set<SupplierOrderDetail> supplierOrderDetails) {


        for (SupplierOrderDetail s1 : supplierOrderDetails
             ) {
            s1.setSupplierOrder(this);
        }
        this.supplierOrderDetails = supplierOrderDetails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
