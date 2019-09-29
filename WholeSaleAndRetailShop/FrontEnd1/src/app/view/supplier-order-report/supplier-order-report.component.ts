import { Component, OnInit } from '@angular/core';
import {SupplierOrderSearchDto} from "../../model/SupplierOrderSearchDto";
import {SupplierOrderService} from "../../service/supplier-order.service";

@Component({
  selector: 'app-supplier-order-report',
  templateUrl: './supplier-order-report.component.html',
  styleUrls: ['./supplier-order-report.component.css']
})
export class SupplierOrderReportComponent implements OnInit {

  constructor(private orderService:SupplierOrderService) { }

  ngOnInit() {
    this.getMonthReceivedOrd();
  }

  month:string;

  monthreceivedorders :Array<SupplierOrderSearchDto> = new Array<SupplierOrderSearchDto>();


  getMonthReceivedOrd(){

    this.orderService.receivedOrders().subscribe((result)=>{

      if(result !=null){
        this.monthreceivedorders=result;
      }
    });
  }

  printReport() {
    this.orderService.printReportSupplierOrd(this.monthreceivedorders ).subscribe((result)=>{

      if(result !=null){

        alert('Report Print SuccessFully');

      }
    });
  }

}
