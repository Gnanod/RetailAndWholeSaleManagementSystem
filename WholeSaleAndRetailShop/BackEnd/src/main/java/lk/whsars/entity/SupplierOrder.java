package lk.whsars.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SupplierOrder {
    @Id
    int supplierOrderId;

    @ManyToOne
    private Supplier supplier;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "supplierOrder")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SupplierOrderDetail> supplierOrderDetails;
//    


}
