import { Component, OnInit } from '@angular/core';
import {Company} from "../../model/Company";
import {CompanyService} from "../../service/company.service";

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  com:Company = new Company();
  constructor(private companyService:CompanyService) { }

  ngOnInit() {
  }

  searchCompanyValueIf = true;
  searchCompanyDetails : Company = new Company();

  searchCompanyName : String;
  companyName : String;
  companyAddress : String;
  emailAddress:String;
  telephone :String;
  faxNumber:String;
  website:String;

  searchCompanyDetailsByName(event:any){
    this.companyService.searchCompanyDetails(this.searchCompanyName).subscribe((result)=>{

      if(result==null){
        this.searchCompanyValueIf = true;
      }else{
        this.searchCompanyValueIf=false;
        this.searchCompanyDetails = result;

        this.companyName = this.searchCompanyDetails.companyName;
        this.companyAddress = this.searchCompanyDetails.address;
        this.emailAddress = this.searchCompanyDetails.address;
        this.telephone = this.searchCompanyDetails.telephone;
        this.faxNumber = this.searchCompanyDetails.fax;
        this.website = this.searchCompanyDetails.website;
      }

    });

  }
  addCompany(){

    console.log("JKDFDGDGD")
    let com:Company;
    this.companyService.addCompany(this.com).subscribe((result)=>{


      if(result!==null){
        alert('Company Added Successfully');
      }
    });



  }



}
