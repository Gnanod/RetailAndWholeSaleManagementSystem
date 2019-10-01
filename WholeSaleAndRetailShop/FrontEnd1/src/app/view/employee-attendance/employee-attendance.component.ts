import { Component, OnInit } from '@angular/core';
import {LowStockLevelDTO} from "../../DTO/LowStockLevelDTO";
import {EmployeeAttendanceDTO} from "../../DTO/EmployeeAttendanceDTO";
import {StockService} from "../../service/stock.service";
import {EmployeeService} from "../../service/employee.service";

@Component({
  selector: 'app-employee-attendance',
  templateUrl: './employee-attendance.component.html',
  styleUrls: ['./employee-attendance.component.css']
})
export class EmployeeAttendanceComponent implements OnInit {

  constructor(private employeeService:EmployeeService) {
  }

  ngOnInit() {
    this.getEmployeeAttendance();
  }

  EmployeeAttendance :Array<EmployeeAttendanceDTO> = new Array<EmployeeAttendanceDTO>();

  getEmployeeAttendance(){
    this.employeeService.employeeAttendance().subscribe((result)=>{

      if(result !=null){
        this.EmployeeAttendance=result;
      }
    });
  }

  printReport(){
    this.employeeService.printReports(this.EmployeeAttendance ).subscribe((result)=>{

      if(result !=null){

        alert('Report Printed Successfully');

      }
    });
  }


}
