package lk.whsars.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int salaryId;
    @OneToOne
    private Employee employee;
}
