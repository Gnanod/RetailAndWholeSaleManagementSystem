import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Employee} from "../../model/Employee";
import {SalaryService} from "../../service/salary.service";
import {Salary} from "../../model/Salary";
import {DatePipe} from "@angular/common";
import {Attendance} from "../../model/Attendance";

@Component({
  selector: 'app-salary',
  templateUrl: './salary.component.html',
  styleUrls: ['./salary.component.css']
})

export class SalaryComponent implements OnInit {

  emp : Array<Salary> = new Array<Salary>();
  empId :string;
  employeeIf = true;
  emplo : Employee = new Employee();
  salary : string;
  sum : number;

  constructor(private router:Router,private salaryservice:SalaryService,private datepipe:DatePipe) { }

  ngOnInit() {
    this.getEmpDetails();
  }

  goToPage() {
    this.router.navigate(['/main/salarysheet']);
  }

  getEmpDetails(){
    this.salaryservice.getEmpDetails().subscribe((result)=>{
      this.emp = result;
      console.log(this.emp);
    })
  }

  searchById() {

    if (this.empId == null) {
      alert("Please Enter EmployeeId")
    } else {

    this.salaryservice.searchById(this.empId).subscribe((result) => {
      if (result == null) {
        this.employeeIf = true;
      } else {
        this.employeeIf = false;
        this.emplo = result;

      }
    })
  }
  }

  addSalary(){
    let sal : Salary = new Salary();

    this.salary = (parseInt(this.emplo.basicsal) + parseInt("1000") + parseInt("8 * 100")).toString();

    sal.payDate = this.datepipe.transform(new Date(),'yyyy-MM-dd');
    sal.workHours = "08";
    sal.salary = this.salary;
    sal.employee = this.emplo;

    this.salaryservice.addSalary(sal).subscribe((result)=>{
      sal = result;
      console.log(result);

      if (result != null) {
        alert('Salary is Calculated');
      }

    })
  }
  salarySum(){
    this.salaryservice.salarySum().subscribe((result)=>{

      console.log(this.sum);
      // this.ans =result ;
      console.log("HHHH"+this.sum)
      this.sum =parseInt(result.toString()) ;
      // this.sum = result.toString();
      // console.log("aaaaa");
      // console.log(this.sum);
    })
  }
}
