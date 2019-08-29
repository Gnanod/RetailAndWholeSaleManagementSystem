package lk.whsars.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Supplier {
    @Id
    String supplierNic;

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
}
