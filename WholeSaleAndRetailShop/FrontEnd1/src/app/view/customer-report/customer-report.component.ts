import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {LowStockLevelDTO} from "../../DTO/LowStockLevelDTO";
import {CustomerReportDTO} from "../../DTO/CustomerReportDTO";

@Component({
  selector: 'app-customer-report',
  templateUrl: './customer-report.component.html',
  styleUrls: ['./customer-report.component.css']
})
export class CustomerReportComponent implements OnInit {

  constructor(private customerService:CustomerService) { }

  ngOnInit() {
    this.getCusDetail();
  }

  CustomerReport :Array<CustomerReportDTO> = new Array<CustomerReportDTO>();

  getCusDetail() {

    this.customerService.CusReport().subscribe((result) => {

      if (result != null) {
        console.log("HHHH")
        this.CustomerReport = result;
      }
    });
  }

  printReport() {
    this.customerService.printCustomerReport(this.CustomerReport ).subscribe((result)=>{

      if(result !=null){

        alert('Report Print SuccessFully');

      }
    });
  }
}
