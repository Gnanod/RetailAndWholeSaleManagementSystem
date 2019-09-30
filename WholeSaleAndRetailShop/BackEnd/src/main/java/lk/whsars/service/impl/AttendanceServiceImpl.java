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

    @Override
    public void deleteAtt(int attendanceId){
        attendanceRepository.deleteById(attendanceId);
    }

    @Override
    public int counter(){

       Object o= attendanceRepository.counter();

        System.out.println("GGGG"+o);

       String a = o.toString();

       int a1 =Integer.parseInt(a);
        System.out.println("DDDD"+a);
        return a1;

    }

    @Override
    public String deleteAttendance(int attId) {
        attendanceRepository.deleteById(attId);
        return "9";
    }

    @Override
    public String checkEmployee(String empid) {

        Object ob = attendanceRepository.checkEmployee(empid);

        System.out.println("OBBBBBBBBBBBBBBBBBBBBB"+ob);
        if(ob !=null){
            return "9";
        }else{
            return null;
        }

    }
}
