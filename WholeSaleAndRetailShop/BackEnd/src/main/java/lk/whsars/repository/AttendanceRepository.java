package lk.whsars.repository;

import lk.whsars.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {

    @Query(value = "from Attendance where attendanceId=?1")
    Attendance searchById(int attendanceId);

    @Query(value = "select sum(attendanceId) from Attendance where day = curdate group by curdate")
    int counter();

}
