import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {EmployeeService} from "../../service/employee.service";
import {Employee} from "../../model/Employee";
//import {Employee, Employee} from "../../model/Employee";

@Component({
  selector: 'app_employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  emp: Employee = new Employee();
  employee: Array<Employee> = new Array<Employee>();

  searchEmployeeValuesIf = true;
  searchEmployee: Employee = new Employee();
  searchEmployeeValues: Employee = new Employee();
  UpdateEmployeeDetails :Employee = new Employee();

  employeename : string;
  employee_id1: number;
  fname1: string;
  lname1: string;
  email1: string;
  nic1: string;
  address1: string;
  birthday1: string;
  phone1: string;
  datejoin1: string;
  basicsal1: string;
  role1:string;
  gender1:string;

  constructor(private route: Router, private employeeService: EmployeeService) {
  }

  GOTOEmployee(){
    this.route.navigate(['/employee'])
  }

  ngOnInit() {
  }

  addEmployee(){
    let emp: Employee;
    this.employeeService.addEmployee(this.emp).subscribe((result)=>{

      emp = result;
      console.log(result);

      if(result!=null){
        alert('Employee Added Successfully');
        this.emp= new Employee();
      }


    });
  }

  getAllEmployee(){

    this.employeeService.getAllEmployee().subscribe((result)=>{
      this.employee=result;
    });

  }


  deleteEmployee(){
    this.employeeService.deleteEmployee(this.searchEmployeeValues.employee_id).subscribe((result)=>{

      if(result==null){

        alert('Employee Deleted SuccessFully');
        this.searchEmployeeValues = new Employee();

      }else{

        alert('Employee Delete Fail');

      }
    });
  }


  UpdateEmployee(){
    let Emp: Employee = new Employee();
    Emp.employee_id = this.employee_id1;
    Emp.fname = this.fname1;
    Emp.lname = this.lname1;
    Emp.email = this.email1;
    Emp.nic = this.nic1;
    Emp.address = this.address1;
    Emp.birthday = this.birthday1;
    Emp.phone = this.phone1;
    Emp.datejoin = this.datejoin1;
    Emp.basicsal = this.basicsal1;
    Emp.role = this.role1;
    Emp.gender = this.gender1;


    this.employeeService.UpdateEmployeeDetails(Emp).subscribe((result)=>{

      if(result!=null){

        alert("Employee details Updated SuccessFully");

      }

    });
  }



  searchByEmployeeName(event: any){


    this.employeeService.searchEmployeeName(this.employeename).subscribe((result)=>{

      //console.log(result);
      if(result==null){
        this.searchEmployeeValuesIf =true;

      }else{

        this.searchEmployeeValuesIf=false;
        this.searchEmployeeValues=result;

        this.employee_id1 = this.searchEmployeeValues.employee_id;
        this.fname1 = this.searchEmployeeValues.fname;
        this.lname1 = this.searchEmployeeValues.lname;
        this.email1 = this.searchEmployeeValues.email;
        this.nic1 = this.searchEmployeeValues.nic;
        this.address1 = this.searchEmployeeValues.address;
        this.birthday1 = this.searchEmployeeValues.birthday;
        this.phone1 = this.searchEmployeeValues.phone;
        this.datejoin1 = this.searchEmployeeValues.datejoin;
        this.basicsal1 = this.searchEmployeeValues.basicsal;
        this.role1 = this.searchEmployeeValues.role;
        this.gender1 = this.searchEmployeeValues.gender;

      }

    });
  }




}
