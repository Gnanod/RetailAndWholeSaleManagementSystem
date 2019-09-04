package lk.whsars.repository;

import lk.whsars.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {

    @Query(value = "from Attendance where attendanceId=?1")
    Attendance searchById(int attendanceId);

    @Query(value = "select count(attendance_id) from Attendance where day =current_date group by current_date ",nativeQuery = true)
    Object counter();

}
