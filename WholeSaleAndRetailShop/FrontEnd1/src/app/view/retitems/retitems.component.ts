import { Component, OnInit } from '@angular/core';
import {ItemService} from "../../service/item.service";
import {CustomerOrderService} from "../../service/customerOrder.service";
import {CustomerOrder} from "../../model/CustomerOrder";
import {Item} from "../../model/Item";
import {RetitemsService} from "../../service/retitems.service";
import {ReturnItemDTO} from "../../model/ReturnItemDTO";
import {StockItemDetails} from "../../model/StockItemDetails";
import {ReturnItem} from "../../model/ReturnItem";
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-return-items',
  templateUrl: './retitems.component.html',
  styleUrls: ['./retitems.component.css']
})


export class ReturnItemsComponent implements OnInit {
  private custO: CustomerOrder;


  constructor(private customerOrderService: CustomerOrderService,
              private itemService: ItemService, private retItemService: RetitemsService,
              private datePipe: DatePipe,) {
  }

  ngOnInit() {
    this.getAllReturnItems();

  }



  returnedItems: Array<ReturnItem> = new Array<ReturnItem>(); //to pass to the all returns table
  retWithRetQuant: ReturnItem = new ReturnItem(); //After getting the returned quantity

  itemretq: number;
  searchItemValuesIf = true;
  searchItemDetails: Array<Item> = new Array<Item>();
  searchorderbyid: number;
  searchitembyid: string;
  ItemDetailsSingle: Item = new Item();

  finalReturn: ReturnItem = new ReturnItem();
  listRetItems: Array<ReturnItem> = new Array<ReturnItem>();

  itemname : string;
  searchitembyitemid: string;

  addCusOrder: CustomerOrder = new CustomerOrder();

  returnItem: ReturnItemDTO = new ReturnItemDTO();

  retitemsTables: Array<ReturnItemDTO> = new Array<ReturnItemDTO>();





  searchOrderById(event: any) {

    this.retItemService.searchRetItemByOrderId(this.searchorderbyid).subscribe((result) => {

      if (result == null) {
        console.log("KKKFDFDF")
      } else {

        this.retitemsTables = result;
        console.log("KnnnF" + result[0].itemname);
      }
    });
  }

  addReturnedItemsFromOrder(itembarcode: string, itemname: string, retQuantity: number, check: number, initunits: number) {

    if(initunits >= retQuantity) {
      this.retWithRetQuant.retItemBarcode = itembarcode;
      this.retWithRetQuant.retItemName = itemname;
      this.retWithRetQuant.retQuant = retQuantity;
      this.retWithRetQuant.notresellableQuant = null;
      this.retWithRetQuant.retDate = this.datePipe.transform(new Date(), 'yyyy-MM-dd');
      this.retWithRetQuant.resellableQuant = null;


      //
      // this.retWithRetQuant.customerOrder = cus;

      this.returnedItems.push(this.retWithRetQuant);
      console.log("ARRAY" + this.returnedItems.length);

      this.retItemService.addReturnedItem(this.retWithRetQuant).subscribe((result) => {

        if (result != null) {
          alert('returned item Added SuccessFully');
          this.getAllReturnItems();
        }
      });

      // this.updateCustomerOrder(this.searchorderbyid, itembarcode);

    } else {
      alert('Return quantity is too large');
    }
  }



  itemquant: number;
  searchItemByBarcode(){
    this.itemService.searchItemDetailsByBarcode(this.searchitembyitemid).subscribe((result)=>{

      if (result == null) {
        console.log("KKKFDFDF")
      } else {

        this.ItemDetailsSingle = result;
        this.itemname = this.ItemDetailsSingle.itemName;
        this.itemquant = this.ItemDetailsSingle.itemQtyOnHand;

        console.log("KnnnF" + result.itemName);
      }
    });
  }



  getAllReturnItems(){
    this.retItemService.getAllReturnItems().subscribe((result)=>{

      this.listRetItems=result;
      //console.log("DATA"+this.listRetItems);
      console.log("DATA"+this.listRetItems.length);
    });

  }




  updateResaleablity(finRet: ReturnItem){
    let totret : number;
    totret = + finRet.notresellableQuant + + finRet.resellableQuant;
    if( totret == finRet.retQuant) {
      let Ret: ReturnItem = new ReturnItem();
      Ret.retItemId = finRet.retItemId;
      Ret.retItemBarcode = finRet.retItemBarcode;
      Ret.retQuant = finRet.retQuant;
      Ret.resellableQuant = finRet.resellableQuant;
      console.log("UPDATAEADSAKLJDA" + finRet.retItemBarcode);
      console.log("UPDATAEADSAKLJDA" + this.finalReturn.retQuant);
      Ret.retDate = finRet.retDate;
      Ret.notresellableQuant = finRet.notresellableQuant;
      Ret.retItemName = finRet.retItemName;
      // Ret.customerOrder.customerOrderId = finRet.customerOrder.customerOrderId;
      //
      // console.log("update frontend wada"+this.finalReturn.customerOrder.customerOrderId);


      this.retItemService.UpdateRetDetails(Ret).subscribe((result) => {

        if (result != null) {

          alert("Ret details Updated SuccessFully");

        }
        this.getAllReturnItems();

      });
    }else{
      alert("Addition of Resalable Quant And nonResalable Quant should be equal to RetQuant")
    }
  }

  deleteEntry(retItemId: number) {
    this.retItemService.deleteReturnEntry(retItemId).subscribe((result)=>{

      if(result==null){

        alert('Employee Deleted SuccessFully');

      }else{

        alert('Employee Delete Fail');

      }
      this.getAllReturnItems();
    });


  }


  // getCustomerObject(custOID: number){
  //
  //
  // }

  // updateCustomerOrder(searchorderbyid: number, itemBar: string) {
  //
  //   //get relevant customer Order object
  //
  //    this.getCustomerObject(searchorderbyid);
  //
  //   //get relevant customer order details object
  //
  //   //get relevant items object????
  //
  //   //update customer price
  //
  //   //update customer order
  //
  //
  //   this.retItemService.UpdateCustOrderDetails(searchorderbyid,itemBar).subscribe((result)=>{
  //     if(result==null){
  //
  //       alert('Order Updated SuccessFully');
  //
  //     }else{
  //
  //       alert('Order Update Fail');
  //
  //     }
  //   });
  //
  // }
}
