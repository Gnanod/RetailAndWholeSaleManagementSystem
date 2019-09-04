package lk.whsars.controller;

import lk.whsars.entity.Attendance;
import lk.whsars.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/attendanceController")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping(value = "/addAtt")
    public Attendance addAttendance(@RequestBody Attendance attendance){
        System.out.println(attendance.getDay());
        return  attendanceService.addAttendence(attendance);

    }

    @GetMapping(value = "/getAtt")
    public List<Attendance> getallattendance(){
        System.out.println("GGGGG");
        return attendanceService.getallattendance();
    }

    @GetMapping(value = "/searchById/{attendanceId}")
    public Attendance searchById(@PathVariable String attendanceId){
        return attendanceService.searchById(attendanceId);

    }

    @PostMapping(value = "/updateOutTime")
    public Attendance updateOutTime(@RequestBody Attendance att){
        return attendanceService.updateOutTime(att);
    }
//
//    @DeleteMapping(value = "/deleteAttendance/{attendanceId)")
//    public void deleteAtt(@PathVariable int attendanceId){
//
//        System.out.println("Attendance"+attendanceId);
//        System.out.println("KKKKKKK");
//
//        attendanceService.deleteAtt(attendanceId);
//
//
//    }

    @GetMapping(value = "/countAttend")
    public int counter(){
    System.out.println("Counter");
        return attendanceService.counter();
    }



    @DeleteMapping(value = "/deleteAttendance/{attId}")
    public String deleteAttendance(@PathVariable int attId){

        System.out.println("JJJJJK");
        return  attendanceService.deleteAttendance(attId);

    }
}
