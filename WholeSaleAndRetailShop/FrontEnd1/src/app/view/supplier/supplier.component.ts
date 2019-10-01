import { Component, OnInit } from '@angular/core';
import {Supplier} from "../../model/Supplier";
import {SupplierService} from "../../service/supplier.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.css']
})
export class SupplierComponent implements OnInit {

  form = new FormGroup({
    date : new FormControl('',Validators.required),
    supplierName : new FormControl('',Validators.required),
    supplierNic : new FormControl('',Validators.required),
    supplierAddress : new FormControl('',Validators.required),
    email : new FormControl('',[Validators.required,Validators.email]),
    phone : new FormControl('',Validators.required),
    fax : new FormControl('',Validators.required),
    cName :new FormControl('',Validators.required)
    //company : new FormControl('',Validators.required)
  })



  supp : Array<Supplier> = new Array<Supplier>();

  sup: Supplier = new Supplier();
  cName:string;




  constructor(private supplierService: SupplierService) {
  }

  ngOnInit() {
    this.getAllCompany();
  }


  searchSupplierValueIf = true;
  searchSupplierDetails: Supplier = new Supplier();

  SearchSupplierNic1: string;
  supplierName1: string;
  supplierAddress: string;
  emailAddress: string;
  phoneNumber: string;
  faxNumber: string;
  supplierNic: string;
  supplierId:number;
  companyName :string;
  date:string;





  searchSupplierDetailsByNic(event: any) {
    this.supplierService.searchSupplierDetails(this.SearchSupplierNic1).subscribe((result) => {

      if (result == null) {
        this.searchSupplierValueIf = true;

      } else {
        this.searchSupplierValueIf = false;
        this.searchSupplierDetails = result;

        this.supplierId = this.searchSupplierDetails.supplierId;
        this.supplierName1 = this.searchSupplierDetails.supplierName;
        this.supplierAddress = this.searchSupplierDetails.address;
        this.emailAddress = this.searchSupplierDetails.email;
        this.phoneNumber = this.searchSupplierDetails.phone;
        this.faxNumber = this.searchSupplierDetails.fax;
        this.supplierNic = this.searchSupplierDetails.supplierNic;


      }

    });
  }

  updateSupplierDetails: Supplier = new Supplier();


  updateSupplier() {

    let sup: Supplier = new Supplier();
    sup.supplierId = this.supplierId;
    sup.supplierNic = this.supplierNic;
    sup.supplierName = this.supplierName1;
    sup.address = this.supplierAddress;
    sup.email = this.emailAddress;
    sup.phone = this.phoneNumber;
    sup.fax = this.faxNumber;

    this.supplierService.updateSupplierDetails(sup).subscribe(result => {
      if (result != null) {
        alert("Supplier Details Updated Successfully");
      }
    });
  }


  addSupplier() {

    let sup: Supplier;

    console.log("this.sup"+this.cName)
    console.log("this.sup"+this.sup.date)
    sup = this.sup;
    sup.companyName=this.cName;


    this.supplierService.addSupplier(sup).subscribe((result) => {
      
      if (result != null) {
        alert("Supplier Added Successfully");
      }
    });

  }

  deleteSupplier() {
    console.log("this.searchSupplierDetails"+this.searchSupplierDetails)
    this.supplierService.deleteSuppliers(this.searchSupplierDetails).subscribe((result) => {

      if (result != null) {
        alert("Supplier Deleted Successfully");
        this.searchSupplierDetails = new Supplier();

      } else {
        alert("Supplier Deleted Fail");
      }
    });


  }


  /////////////////////////////////////////////////////////////////////////////////




  getAllCompany(){
    this.supplierService.getAllCompany().subscribe((result)=>{
      this.supp = result;
      this.supp[0]=result[0];

    });
  }










}



