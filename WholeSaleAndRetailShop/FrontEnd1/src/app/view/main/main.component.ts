import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  headerText: string;

  constructor(private router:Router) {

    router.events.subscribe((val) => {
      this.setHeaderTextAndButtons();
    });

  }

  ngOnInit() {
  }

  setHeaderTextAndButtons() {

    if (this.router.url == '/main/dashboard') {
      this.headerText = "Dashboard";
    } else if (this.router.url == '/main/customer_vehicle') {
      this.headerText = "Customer Vehicle Details";
    } else if (this.router.url == '/main/employee') {
      this.headerText = "Employees";
    } else if(this.router.url == '/main/searchVehicle'){
      this.headerText = "SearchVehicle";
    } else if(this.router.url == '/main/customerVehicle'){
      this.headerText = "AddVehicle";
    } else if(this.router.url== '/main/supplier'){
      this.headerText="Supplier";
    }  else if(this.router.url== "/main/supplierorder"){
      this.headerText="SupplierOrder";
    } else if(this.router.url== '/main/supplier') {
      this.headerText = "Supplier";
    }else if(this.router.url== '/main/salary'){
      this.headerText="Salary";
    }else if(this.router.url== '/main/attendance'){
      this.headerText="Attendance";
    }else if (this.router.url=='/main/StockHandling'){
      this.headerText="StockHandling";
    }else if (this.router.url=='/main/customer'){
      this.headerText="Customers";
    }else if(this.router.url== '/main/supplier') {
      this.headerText = "Supplier";
    }else if(this.router.url == '/main/Company'){
      this.headerText="Company";
    }


  }

  changeRoute(button) {
    console.log(button)
    if (button == "Dashboard") {
      this.router.navigate(['/main/dashboard'])
    } else if (button == "Employees") {
      this.router.navigate(['/main/employee'])
    } else if (button == "SearchVehicle") {
      this.router.navigate(['/main/searchVehicle'])
    } else if (button == "AddVehicle") {
      this.router.navigate(['/main/customerVehicle'])
    } else if (button == "Supplier") {
      this.router.navigate(['/main/supplier'])
    } else if (button == "SupplierOrder") {
      this.router.navigate(['/main/supplierorder'])
    }else if(button == "Salary"){
      this.router.navigate(['/main/salary'])
    }else if(button == "Attendance"){
      this.router.navigate(['/main/attendance'])
    }else if(button == "StockHandling"){
      this.router.navigate(['/main/StockHandling'])
    }else if(button=="Customer"){
      this.router.navigate(['/main/customer'])
    }else if (button == "Supplier") {

      this.router.navigate(['/main/supplier'])

    }else if(button == "Company"){

      this.router.navigate(['/main/Company'])

    }else if(button == 'LowStockLevel'){

      this.router.navigate(['/main/LowStockLevel'])

    }else if(button == 'Customer Orders'){

      this.router.navigate(['/main/CustomerOrderReport'])

    }
    else if(button == 'Employee Attendance'){

      this.router.navigate(['/main/EmployeeAttendance'])

    }

  }


}

