import { Component, OnInit } from '@angular/core';
import {Company} from "../../model/Company";
import {CompanyService} from "../../service/company.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

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






  form = new FormGroup({
    companyName : new FormControl('',Validators.required),
    companyAddress : new FormControl('',Validators.required),
    email : new FormControl('',[Validators.required,Validators.email]),
    telephone : new  FormControl('',Validators.required),
    fax : new FormControl('',Validators.required),
    website : new FormControl('',Validators.required)


  });


  searchCompanyValueIf = true;
  searchCompanyDetails: Company = new Company();

  searchCompanyName1 : String;
  companyName : String;
  companyAddress : String;
  emailAddress:String;
  telephone :String;
  faxNumber:String;
  website:String;

  searchCompanyDetailsByName(event:any){
    this.companyService.searchCompanyDetails(this.searchCompanyName1).subscribe((result)=>{

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
