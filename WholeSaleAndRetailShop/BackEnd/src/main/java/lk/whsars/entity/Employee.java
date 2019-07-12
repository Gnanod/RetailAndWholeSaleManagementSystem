package lk.whsars.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;
//
@Entity
public class Employee {

    @Id
    private String employeeId;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "employee")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Attendance> attendances;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "employee")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Salary salary;







}
