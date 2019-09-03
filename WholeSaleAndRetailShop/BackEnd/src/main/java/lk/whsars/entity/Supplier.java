package lk.whsars.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Supplier {
    @Id
    String supplierNic;
    String suppliername;
    String company;

//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private Company company;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "supplier")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<SupplierOrder> supplierOrders;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Stock> stock;

    public String getSupplierNic() {
        return supplierNic;
    }

    public void setSupplierNic(String supplierNic) {
        this.supplierNic = supplierNic;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getCompany() {
        return company;
    }

//    public void setCompany(Company company) {
//        this.company = company;
//    }

    public Set<SupplierOrder> getSupplierOrders() {
        return supplierOrders;
    }

    public void setSupplierOrders(Set<SupplierOrder> supplierOrders) {
        this.supplierOrders = supplierOrders;
    }

    public Set<Stock> getStock() {
        return stock;
    }

    public void setStock(Set<Stock> stock) {
        this.stock = stock;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
