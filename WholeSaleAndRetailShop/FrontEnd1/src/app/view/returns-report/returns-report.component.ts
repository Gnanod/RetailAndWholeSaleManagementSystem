import { Component, OnInit } from '@angular/core';
import {RetitemsService} from "../../service/retitems.service";
import {ReturnItem} from "../../model/ReturnItem";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-returns-report',
  templateUrl: './returns-report.component.html',
  styleUrls: ['./returns-report.component.css']
})
export class ReturnsReportComponent implements OnInit {
  private listRetItems2: Array<ReturnItem> = new Array<ReturnItem>();
  private monthnowName: String;

  constructor(private retItemService: RetitemsService) { }

  ngOnInit() {

  }
  ///////////////////////////////////////////////////////////////FOR ALL THE RETURN ITEMS //////////////////////////////////////////////
  listRetItems : Array<ReturnItem> = new Array<ReturnItem>();
  monthnow: string;

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

  getAllReturnItemsByMonth(){

    if(this.monthnow=="01"){
      this.monthnowName = "January";
    }else if(this.monthnow =="02"){
      this.monthnowName = "February";
    }else if(this.monthnow =="03"){
      this.monthnowName = "March";
    }else if(this.monthnow =="04"){
      this.monthnowName = "April";
    }else if(this.monthnow =="05"){
      this.monthnowName = "May";
    }else if(this.monthnow =="06"){
      this.monthnowName = "June";
    }else if(this.monthnow =="07"){
      this.monthnowName = "July";
    }else if(this.monthnow =="08"){
      this.monthnowName = "August";
    }else if(this.monthnow =="09"){
      this.monthnowName = "September";
    }else if(this.monthnow =="10"){
      this.monthnowName = "October";
    }else if(this.monthnow =="11"){
      this.monthnowName = "November";
    }else if(this.monthnow =="12"){
      this.monthnowName = "December";
    }else if(this.monthnow ==""){
      this.monthnowName = "";
    }



    console.log("MONTHH "+this.monthnow);
    this.retItemService.getAllReturnItemsByMonth(this.monthnow).subscribe((result)=>{

      this.listRetItems=result;
      //console.log("DATA"+this.listRetItems);
      console.log("DATA"+this.listRetItems.length);
    });

  }

}
