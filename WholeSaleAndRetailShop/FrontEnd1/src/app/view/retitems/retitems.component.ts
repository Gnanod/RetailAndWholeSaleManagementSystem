import { Component, OnInit } from '@angular/core';
import {ItemService} from "../../service/item.service";
import {CustomerOrderService} from "../../service/customerOrder.service";
import {CustomerOrder} from "../../model/CustomerOrder";
import {Item} from "../../model/Item";
import {RetitemsService} from "../../service/retitems.service";
import {ReturnItemDTO} from "../../model/ReturnItemDTO";
import {StockItemDetails} from "../../model/StockItemDetails";
import {ReturnItem} from "../../model/ReturnItem";
import {Brand} from "../../model/Brand";
import {Customer} from "../../model/Customer";
import {FormControl, FormGroup} from "@angular/forms";
import {Employee} from "../../model/Employee";

@Component({
  selector: 'app-return-items',
  templateUrl: './retitems.component.html',
  styleUrls: ['./retitems.component.css']
})
export class ReturnItemsComponent implements OnInit {


  constructor(private customerOrderService: CustomerOrderService,
              private itemService: ItemService, private retItemService: RetitemsService) {
  }

  returnedItems: Array<ReturnItem> = new Array<ReturnItem>(); //to pass to the all returns table
  retWithRetQuant: ReturnItem = new ReturnItem(); //After getting the returned quantity

  itemretq: number;
  searchItemValuesIf = true;
  searchItemDetails: Array<Item> = new Array<Item>();
  searchorderbyid: number;
  searchitembyid: string;
  ItemDetailsSingle: Item = new Item();

  finalReturn: ReturnItem = new ReturnItem()
  listRetItems: Array<ReturnItem> = new Array<ReturnItem>();

  itemname : string;
  searchitembyitemid: string;

  addCusOrder: CustomerOrder = new CustomerOrder();

  returnItem: ReturnItemDTO = new ReturnItemDTO();

  retitemsTables: Array<ReturnItemDTO> = new Array<ReturnItemDTO>();

  ngOnInit() {
    this.getAllReturnItems();
  }



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

  addReturnedItemsFromOrder(itembarcode: string, itemname: string, retQuantity: number, check: number) {

    this.retWithRetQuant.retItemBarcode = itembarcode;
    this.retWithRetQuant.retItemName = itemname;
    this.retWithRetQuant.retQuant = retQuantity;
    this.retWithRetQuant.notresellableQuant = null;
    this.retWithRetQuant.retDate = '';
    this.retWithRetQuant.resellableQuant = null;
    let cus : CustomerOrder = new CustomerOrder();
    if (check == 1) {
      cus.customerOrderId = this.searchorderbyid;
    }else{
       cus.customerOrderId = 2;
    }

    this.retWithRetQuant.customerOrder=cus;

    this.returnedItems.push(this.retWithRetQuant);
    console.log("ARRAY" + this.returnedItems.length);

    this.retItemService.addReturnedItem(this.retWithRetQuant).subscribe((result) => {

      if (result != null) {
        alert('returned item Added SuccessFully');
      }
    });
  }



  searchItemByBarcode(){
    this.itemService.searchItemDetailsByBarcode(this.searchitembyitemid).subscribe((result)=>{

      if (result == null) {
        console.log("KKKFDFDF")
      } else {

        this.ItemDetailsSingle = result;
        this.itemname = this.ItemDetailsSingle.itemName;

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


  updateResaleablity(r: number, nr: number){
    let Ret: ReturnItem = new ReturnItem();
    Ret.retItemId = this.finalReturn.retItemId;
    Ret.retItemBarcode = this.finalReturn.retItemBarcode;
    Ret.retQuant = this.finalReturn.retQuant;
    Ret.resellableQuant = this.finalReturn.resellableQuant;
    Ret.retDate= this.finalReturn.retDate;
    Ret.notresellableQuant = this.finalReturn.notresellableQuant;
    Ret.retItemName = this.finalReturn.retItemName;
    Ret.customerOrder.customerOrderId = this.finalReturn.customerOrder.customerOrderId;



    this.retItemService.UpdateRetDetails(Ret).subscribe((result)=>{

      if(result!=null){

        alert("Retloyee details Updated SuccessFully");

      }

    });
  }

  deleteEntry(retItemId: number) {
      this.retItemService.deleteReturnEntry(retItemId).subscribe((result)=>{

        if(result==null){

          alert('Employee Deleted SuccessFully');

        }else{

          alert('Employee Delete Fail');

        }
      });


  }
}
