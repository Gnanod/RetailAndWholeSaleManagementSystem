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
//
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "supplier")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Stock> stock;


}
