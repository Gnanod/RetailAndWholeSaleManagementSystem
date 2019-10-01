import { Component, OnInit } from '@angular/core';
import {SupplierOrderDetail} from "../../model/SupplierOrderDetail";
import {SupplierOrderService} from "../../service/supplier-order.service";
import {Company} from "../../model/Company";
import {Supplier} from "../../model/Supplier";
import {ItemService} from "../../service/item.service";
import {Item} from "../../model/Item";
import {SupplierOrder} from "../../model/SupplierOrder";
import {DatePipe} from "@angular/common";
import {SupplierOrderSearchDto} from "../../model/SupplierOrderSearchDto";
import {environment} from "../../../environments/environment.prod";

@Component({
  selector: 'app-supplier-order',
  templateUrl: './supplier-order.component.html',
  styleUrls: ['./supplier-order.component.css']
})
export class SupplierOrderComponent implements OnInit {

  //delete order
  deletesuporder: SupplierOrder = new SupplierOrder();
  supOrderId:string;
  searchDeleteValueIf=true;
  searchDeleteOrders: SupplierOrderSearchDto = new SupplierOrderSearchDto();


  constructor(
    private make_company : SupplierOrderService,private supplierService:SupplierOrderService,
    private make_agent:SupplierOrderService,
    private productService:ItemService,
    private datePipe: DatePipe,
    private supplierorderservice: SupplierOrderService

  ) { }

  ngOnInit() {
    this.getAllCompanies();
  }

  //////////////Search order /////////////
  searchOrderById :string;


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

  //get All items
  selectedAgentNic :Supplier = new Supplier();
  itemsArray : Array<Item> = new Array<Item>();

  //getAllOrders
  orders : Array<SupplierOrder> = new Array<SupplierOrder>();

  //searchorder
  searchOrder : SupplierOrderSearchDto = new SupplierOrderSearchDto();
  searchOrderValuesIf = true;


  //updateOrderStatus
  updateStatus :SupplierOrder = new SupplierOrder();
  updatestatus:String

  //supplier Item Quantity

  supplierItemQuantity:number;

  //Add Items To Table
  supplierOrderDetailsArray : Array<SupplierOrderDetail> = new Array<SupplierOrderDetail>();
  totalAmount : number = 0 ;

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



    this.make_company.getAgentDetails(this.insertCompany).subscribe(result=>{

      if(result!=null){


       this.searchMakesByCompany=result;
       console.log("ggdsda"+result[0].supplierNic);
        this.selectedAgentNic=this.searchMakesByCompany[0];
        //console.log(" this.selectedAgentNic"+ result[0].company)
      }
    });
  }

  getItemDetails(itemObject :Supplier){

    console.log("GGGGGG"+this.selectedAgentNic.supplierNic);

    this.make_company.getItemDetails(this.selectedAgentNic.supplierNic).subscribe(result=>{

      if(result!=null){

        this.itemsArray=result;
        this.itemsArray[0]=result[0];
       // this.searchMakesByCompany=result;
      //  console.log("ggdsda"+result[0].supplierNic);
      //  this.selectedAgentNic=this.searchMakesByCompany[0];
        //console.log(" this.selectedAgentNic"+ result[0].company)
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


  AddItemsToTable(barCode: string, itemName: string, supplierItemQuantity: number,retailPrice :number) {

    if( supplierItemQuantity == 0){
      alert("Please Enter Quantity!!!");
    }else {
      let supplierOrderDetail: SupplierOrderDetail = new SupplierOrderDetail();

      let itemDetails: Item = new Item();
      itemDetails.itemName = itemName;
      itemDetails.barCode = barCode;

      supplierOrderDetail.item = itemDetails;
      supplierOrderDetail.quantity = supplierItemQuantity;
      supplierOrderDetail.price = retailPrice * supplierItemQuantity;
      this.totalAmount += supplierItemQuantity * retailPrice;
      this.supplierOrderDetailsArray.push(supplierOrderDetail);

    }

  }

  saveJobOrder() {


      let supplierOrder: SupplierOrder = new SupplierOrder();

      supplierOrder.companyName = this.insertCompany;
      supplierOrder.supplier = this.selectedAgentNic;
      supplierOrder.total = this.totalAmount;
      supplierOrder.status = "false";
      supplierOrder.supplierOrderDetails = this.supplierOrderDetailsArray;
      supplierOrder.date = this.datePipe.transform(new Date(), 'yyyy-MM-dd');

      this.make_agent.saveJoBOrder(supplierOrder).subscribe(result => {


        if (result != null) {

          alert("Successfully place order")
          // this.searchMakesByCompany=result;

        }
      });
  }

  deleteOrderRow(id){
    console.log("FGSDSDS");

    for(let i = 0; i < this.supplierOrderDetailsArray.length; ++i){
      if (this.supplierOrderDetailsArray[i].item.barCode === id) {

        var price :number = this.supplierOrderDetailsArray[i].price;
        console.log("price ="+price);

        var quantity :number =this.supplierOrderDetailsArray[i].quantity;
        console.log("quantity ="+quantity);

        let tot:number=price/quantity;
        console.log("Total"+tot);
        console.log("tot amount =  ="+this.totalAmount);
        this.totalAmount = this.totalAmount-price;
        console.log("tot amount =  ="+this.totalAmount);
        this.supplierOrderDetailsArray.splice(i,1);


      }
    }
  }

  searchOrderByOrderId(event:string){

    if(this.searchOrderById.length!=0){
      this.supplierorderservice.searchOrder(this.searchOrderById).subscribe((result)=>{

        if(result==null){
          this.searchOrderValuesIf = true ;
        }
        else{


          this.searchOrderValuesIf = false;
          this.searchOrder = result;

          console.log('LKsadasdasdsadasdsadasdsadKKK'+ this.searchOrder.supplierNIC);

          let supplierorder :SupplierOrder = new SupplierOrder();

          supplierorder.date=this.searchOrder.date;
          supplierorder.companyName=this.searchOrder.companyName;

          let supplier = new Supplier();

          supplier.supplierNic = this.searchOrder.supplierNIC;
          supplier.supplierId=this.searchOrder.supplierId;

          console.log("YYYYYYYYYY"+this.searchOrder.supplierId)

          console.log('LKKKK'+ supplier.supplierNic);
          supplier.supplierName=this.searchOrder.supplierName;
          supplierorder.supplier=supplier;

          supplierorder.status="TRUE";
          supplierorder.total=this.searchOrder.total;

          // this.updateStatus.supplier = supplier;
          // this.updateStatus.supplierOrderId=parseInt(this.searchOrderById);
          // this.updateStatus.total
          this.updateStatus= supplierorder;
          this.updateStatus.supplierOrderId=this.searchOrderById;

          //  this.updatestatus = this.searchOrder.status;

          console.log('PRINT UPDATE ' + this.searchOrder.supplierOrderId)
        }
      })
    }

  }

  updateSupplierOrder(){

    let SupplierOrderlet = new SupplierOrder()


    this.supplierorderservice.updateSupplierOrder(this.updateStatus).subscribe((result)=>{

      if(result!=null){
        alert('Updated SuccessFully');
      }
    });
  }

  searchDeleteOrders1(event:string){
    this.supplierorderservice.searchOrderDelete(this.supOrderId).subscribe((result)=> {

      if (result == null) {
        this.searchDeleteValueIf = true;
      }
      else {
        this.searchDeleteValueIf =false;
        this.searchDeleteOrders = result;

        let supDelOrder:SupplierOrder = new SupplierOrder();

        supDelOrder.supplierOrderId = this.searchDeleteOrders.supplierOrderId;
        supDelOrder.companyName = this.searchDeleteOrders.companyName;

        let supname :Supplier = new Supplier();
        supname.supplierName = this.searchDeleteOrders.supplierName;

        supDelOrder.date= this.searchDeleteOrders.date;
        supDelOrder.total= this.searchDeleteOrders.total;
        supDelOrder.status = this.searchDeleteOrders.status;
      }


    })
  }

  deleteSupplierOrder(){
    this.supplierorderservice.deleteSupplierOrder(this.supOrderId).subscribe((result)=>{
      if(result != null){
        alert('Deleted Successfully');

      }else{
        alert('failed');
      }
    })
  }


}




