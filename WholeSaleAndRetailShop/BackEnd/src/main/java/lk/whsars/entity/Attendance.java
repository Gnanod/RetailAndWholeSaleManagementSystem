package lk.whsars.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Attendance {

    @Id
    int attendanceId;

    @ManyToOne
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Employee employee;

}
