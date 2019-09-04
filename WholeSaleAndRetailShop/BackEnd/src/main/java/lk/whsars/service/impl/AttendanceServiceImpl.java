package lk.whsars.service.impl;

import lk.whsars.entity.Attendance;
import lk.whsars.repository.AttendanceRepository;
import lk.whsars.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.OneToMany;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getallattendance(){
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance searchById(String attendanceId){
        return attendanceRepository.searchById(Integer.parseInt(attendanceId));
    }

    @Override
    public Attendance addAttendence(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance updateOutTime(Attendance att){
        return attendanceRepository.save(att);
    }

    @DeleteMapping
    public void deleteAtt(int attendanceId){
        attendanceRepository.deleteById(attendanceId);
    }

    @Override
    public int counter(){
        return attendanceRepository.counter();
    }

    @Override
    public String deleteAttendance(int attId) {
        attendanceRepository.deleteById(attId);
        return "9";
    }
}
