import { Component, OnInit } from '@angular/core';
import {RetitemsService} from "../../service/retitems.service";
import {ReturnItem} from "../../model/ReturnItem";

@Component({
  selector: 'app-returns-report',
  templateUrl: './returns-report.component.html',
  styleUrls: ['./returns-report.component.css']
})
export class ReturnsReportComponent implements OnInit {

  constructor(private retItemService: RetitemsService) { }

  ngOnInit() {
  }
  ///////////////////////////////////////////////////////////////FOR ALL THE RETURN ITEMS //////////////////////////////////////////////
  listRetItems : Array<ReturnItem> = new Array<ReturnItem>();

  getAllReturnItems(){
    this.retItemService.getAllReturnItems().subscribe((result) => {

      this.listRetItems = result;
      //console.log("DATA"+this.listRetItems);
      console.log("DATA" + this.listRetItems.length);
    });
  }




  printAllTimeReport(){
    this.retItemService.printAllTimeReport(this.listRetItems).subscribe((result)=>{

      if(result !=null){

        alert('Report Print SuccessFully');

      }
    });
  }


}
