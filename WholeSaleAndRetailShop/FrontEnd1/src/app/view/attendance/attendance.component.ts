import { Component, OnInit } from '@angular/core';
import {Attendance} from "../../model/Attendance";
import {AttendanceService} from "../../service/attendance.service";
import {DatePipe} from "@angular/common";
import {Employee} from "../../model/Employee";


@Component({
  selector: 'app-attendance',
  templateUrl: './attendance.component.html',
  styleUrls: ['./attendance.component.css']
})
export class AttendanceComponent implements OnInit {

  empId :string;
  attend : Array<Attendance> = new Array<Attendance>();
  searchatt : Attendance = new Attendance();
  searchAttIf = true;
  searchAttendance : Attendance = new Attendance();
  att : Attendance = new Attendance();
  attendanceId :string;
  deleteatt : Attendance = new Attendance();
  ans :Attendance = new Attendance();
  //ans: string;

  constructor(private attendanceService:AttendanceService,private datepipe:DatePipe) { }

  ngOnInit() {
    this.getallattendance();
    //this.searchAttIf = true;
  }

  getallattendance(){
    this.attendanceService.getallattendance().subscribe((result)=>{
      this.attend= result;

    });
  }

  searchById(){
    this.attendanceService.searchById(this.attendanceId).subscribe((result)=>{

      console.log(result);
      if(result == null){
        this.searchAttIf = true;
      }else{
        this.searchAttIf = false;
        this.searchatt = result;
        this.deleteatt.attendanceId = result.attendanceId;
      }
    });
  }

  addAttendance(id){

    let att : Attendance = new Attendance();

    att.day = this.datepipe.transform(new Date(),'yyyy-MM-dd');
    console.log("KKK"+att.day);
    att.inTime = this.datepipe.transform(new Date(),'HH-MM-SS', )
    let emp :Employee = new Employee();

    emp.employee_id=parseInt(id);

    att.employee=emp;

    console.log("LLLLLLL"+emp.employee_id);

    if(this.empId == null){

      alert("Please Enter Employee Id")
    }
    else {

      this.attendanceService.addAttendance(att).subscribe((result) => {

        att = result;
        result.attendanceId = att.attendanceId;

        console.log(result);

        if (result != null) {
          alert('Added Successfully');
          this.att = new Attendance();
        }
      })
    }
  }

  updateOutTime(id, intime, day,emp,outtime) {
    if (outtime != null) {
      alert("Can Not Update Time Again")
    } else {


      let outTime: Attendance = new Attendance();
      outTime.attendanceId = id;
      outTime.inTime = intime;
      outTime.day = day;
      outTime.employee = emp;

      outTime.outTime = this.datepipe.transform(new Date(), 'HH-MM-SS', );

      this.attendanceService.updateOutTime(outTime).subscribe((result) => {

        if (result != null) {
          alert("Out Time Updated")
        }
      })

    }
  }

  deleteAtt(){

    this.attendanceService.deleteAtt(this.deleteatt.attendanceId).subscribe((result)=>{
      if(result == null){
        alert('Deleted Successfully');
      }else{
        alert('failed');
      }
    })
  }

  deleteAttendance(){
    this.attendanceService.deletAttendace(this.deleteatt.attendanceId).subscribe((result)=>{
      if(result == null){
        alert('Deleted Successfully');
      }else{
        alert('failed');
      }
    })
  }
  counter(){
    this.attendanceService.counter().subscribe((result)=>{
      console.log(this.ans);
      this.ans =result ;
    })
  }
}
