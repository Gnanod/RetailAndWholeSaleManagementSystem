import { Component, OnInit } from '@angular/core';
import {StockService} from "../../service/stock.service";
import {LowStockLevelDTO} from "../../DTO/LowStockLevelDTO";

@Component({
  selector: 'app-low-stock-level',
  templateUrl: './low-stock-level.component.html',
  styleUrls: ['./low-stock-level.component.css']
})
export class LowStockLevelComponent implements OnInit {

  constructor(private stockService:StockService) { }

  ngOnInit() {
    this.getLowStockLevel();
  }

  LowStockLevel :Array<LowStockLevelDTO> = new Array<LowStockLevelDTO>();


  getLowStockLevel(){

    this.stockService.lowStock().subscribe((result)=>{

      if(result !=null){
        this.LowStockLevel=result;
      }
    });
  }

  printReport() {
    this.stockService.printReports(this.LowStockLevel ).subscribe((result)=>{

      if(result !=null){

        alert('Report Print SuccessFully');

      }
    });
  }


}
