import { Component, OnInit } from '@angular/core';
import {SupplierOrderDetail} from "../../model/SupplierOrderDetail";
import {SupplierOrderService} from "../../service/supplier-order.service";
import {Company} from "../../model/Company";
import {Supplier} from "../../model/Supplier";
import {ItemService} from "../../service/item.service";
import {Item} from "../../model/Item";

@Component({
  selector: 'app-supplier-order',
  templateUrl: './supplier-order.component.html',
  styleUrls: ['./supplier-order.component.css']
})
export class SupplierOrderComponent implements OnInit {

  constructor(
    private make_company : SupplierOrderService,private supplierService:SupplierOrderService,
    private make_agent:SupplierOrderService,
    private productService:ItemService
  ) { }

  ngOnInit() {
    this.getAllCompanies();
  }


  //Insert Company
  insertCompany:string;
  searchMakesByCompany: Array<Supplier> = new Array<Supplier>();

  //Insert Agent
  insertAgent:string;
  searchMakesByAgent: Array<Supplier> = new Array<Supplier>();


  //getAllCompany
  companies: Array<Company> = new Array<Company>();
  selectedSupplierCompany :string;

  //getAllSupplier
  agent: Array<Supplier> = new Array<Supplier>();

  //searchByProductName
  searchProductName:string;
  searchProductValuesIf=true;
  searchProductDetails : Item = new Item();


  getAllCompanies() {

    console.log(this.insertCompany);
    this.supplierService.getAllCompany().subscribe((result) => {
      this.companies = result;
    //  this.insertCompany=this.companies[0].companyName;
    });

  }

  getAllAgent() {

    this.supplierService.getAllAgent(this.insertCompany).subscribe((result) => {
      this.agent = result;
    });

  }


  ////////////////////////////////////////////////////

  getMakeCompanyDetails(value :string){

console.log("HHHH"+this.insertCompany);
console.log("GGGG"+value)


    this.make_company.getAgentDetails(this.insertCompany).subscribe(result=>{

      if(result!=null){

        console.log("KLLLLLL"+result[0].suppliername)
       this.searchMakesByCompany=result;

      }
    });
  }

  getMakeAgentDetails(value :string){


    this.make_agent.getAgentDetails(value).subscribe(result=>{

      console.log("First")
      if(result!=null){


        this.searchMakesByCompany=result;


      }
    });
  }

  searchByProductName(){

    this.productService.searchByProductName(this.searchProductName).subscribe((result)=>{

      if(result==null){
        this.searchProductValuesIf=true;

      }else{
        this.searchProductValuesIf=false;
        this.searchProductDetails = result;
      }

    });
  }




}


