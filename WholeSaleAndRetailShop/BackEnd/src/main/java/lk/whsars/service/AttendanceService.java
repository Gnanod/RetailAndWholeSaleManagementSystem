package lk.whsars.service;

import lk.whsars.entity.Attendance;

import java.util.List;

public interface AttendanceService {

    List<Attendance> getallattendance();

    Attendance searchById(String attendanceId);

    Attendance addAttendence(Attendance attendance);

    Attendance updateOutTime(Attendance att);

    void deleteAtt(int attendanceId);

    int counter();

    String deleteAttendance(int attId);
}
