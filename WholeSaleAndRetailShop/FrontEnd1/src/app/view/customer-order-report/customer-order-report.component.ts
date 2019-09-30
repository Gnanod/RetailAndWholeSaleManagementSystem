import {Component, OnInit} from '@angular/core';
import {CustomerOrderService} from "../../service/customerOrder.service";
import {CustomerOrderReportDTO} from "../../DTO/CustomerOrderReportDTO";

@Component({
  selector: 'app-customer-order-report',
  templateUrl: './customer-order-report.component.html',
  styleUrls: ['./customer-order-report.component.css']
})
export class CustomerOrderReportComponent implements OnInit {

  CustomerOrders: Array<CustomerOrderReportDTO> = new Array<CustomerOrderReportDTO>();

  constructor(private customerOrderReports: CustomerOrderService) {
  }

  ngOnInit() {
    this.getCustomerOrders()
  }

  getCustomerOrders() {
    this.customerOrderReports.getCustomerOrders().subscribe((result) => {

      if (result != null) {
        this.CustomerOrders = result;
      }
    });
  }

  printReport() {
    this.customerOrderReports.printReports(this.CustomerOrders).subscribe((result) => {

      if (result != null) {
        alert('Report Print SuccessFully');
      }
    });
  }

}
