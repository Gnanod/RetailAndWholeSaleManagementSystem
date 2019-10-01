import { Component, OnInit } from '@angular/core';
import {SalaryService} from "../../service/salary.service";
import {SalarySheetDTO} from "../../DTO/SalarySheetDTO";

@Component({
  selector: 'app-salary-sheet-report',
  templateUrl: './salary-sheet-report.component.html',
  styleUrls: ['./salary-sheet-report.component.css']
})
export class SalarySheetReportComponent implements OnInit {

  constructor(private salaryservice:SalaryService) { }

  sal : Array<SalarySheetDTO> = new Array<SalarySheetDTO>();

  ngOnInit() {
    this.getSalaryDetails();
  }


  getSalaryDetails(){

    console.log("GGGGG");
    this.salaryservice.getSalaryDetails().subscribe((result)=>{
      if(result!=null){
        this.sal = result;
      }
    })
  }


  printSalaryReport() {
    this.salaryservice.printReports(this.sal).subscribe((result)=>{

      alert('Report Print SuccessFully');
      // if(result !=null){
      //   alert('Report Print SuccessFully');
      // }
    });
  }
}
