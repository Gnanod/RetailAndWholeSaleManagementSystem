import { Component, OnInit } from '@angular/core';
import {SupplierService} from "../../service/supplier.service";
import {Supplier} from "../../model/Supplier";
import {SupplierDetailDTO} from "../../DTO/SupplierDetailDTO";

@Component({
  selector: 'app-supplier-report',
  templateUrl: './supplier-report.component.html',
  styleUrls: ['./supplier-report.component.css']
})
export class SupplierReportComponent implements OnInit {

  constructor(private supplierService:SupplierService) { }

  supp : Array<Supplier> = new Array<Supplier>();


  ngOnInit() {
    this.getSupplierReport();
  }

  SupplierReport :Array<SupplierDetailDTO> = new Array<SupplierDetailDTO>();

  getSupplierReport(){

    this.supplierService.getSupplierDetailsReport().subscribe((result)=>{

      if(result !=null){
        this.SupplierReport=result;
      }
    });


  }




  printReport() {
    this.supplierService.printReports(this.SupplierReport ).subscribe((result)=>{

      if(result !=null){

        alert('Report Print SuccessFully');

      }
    });
  }

}
