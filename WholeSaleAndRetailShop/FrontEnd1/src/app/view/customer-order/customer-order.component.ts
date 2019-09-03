import { Component, OnInit } from '@angular/core';
import {Item} from "../../model/Item";
import {Customer} from "../../model/Customer";
import {CustomerOrder} from "../../model/CustomerOrder";
import {CustomerOrderDetail} from "../../model/CustomerOrderDetail";
import {CustomerOrderService} from "../../service/customerOrder.service";
import {ItemService} from "../../service/item.service";

@Component({
  selector: 'app-customer-order',
  templateUrl: './customer-order.component.html',
  styleUrls: ['./customer-order.component.css']
})
export class CustomerOrderComponent implements OnInit {

  constructor(private customerOrderService :CustomerOrderService,
              private itemService :ItemService) {

  }

  time = new Date();

  ngOnInit() {
    setInterval(() => {
      this.time = new Date();
    }, 1000);
  }


  itemName:string;
  brand:string;
  qty:number;
  itemCount : number = 1;
  discount : number;
  totalPrice : number = 0;
  itemPrice:number =0;
  curDate=new Date();
  customerId : number = 1;
  itemQtyOnHand : number = 0;
  updateItemQty : number = 0;

  searchItemValuesIf = true;
  searchItemDetails:Array<Item> = new Array<Item>();
  searchitembynameOrId:string;

  Cusdetail :Customer = new Customer();

  addCusOrder :CustomerOrder = new CustomerOrder();
  CusOrder :Array<CustomerOrder> = new Array<CustomerOrder>();

  orderList:Array<CustomerOrderDetail> = new Array<CustomerOrderDetail>();


  cusOrderDetail(){
    //console.log(this.textModel1);
    let orderListDetail:CustomerOrderDetail = new CustomerOrderDetail();
    let orderItemDetail:Item = new Item();
    this.searchItemDetails.forEach(function (value) {
      orderItemDetail.barCode = value.barCode;
      orderItemDetail.itemName = value.itemName;
      orderItemDetail.brand = value.brand;
      orderItemDetail.retailPrice = value.retailPrice;
      orderItemDetail.itemQtyOnHand = value.itemQtyOnHand;
    })

      // orderItemDetail.barCode = this.searchItemDetails.barCode;
      // orderItemDetail.itemName = this.searchItemDetails.itemName;
      // orderItemDetail.brand = this.searchItemDetails.brand;
      // orderItemDetail.retailPrice = this.searchItemDetails.retailPrice;

    // orderItemDetail.barCode = "000000001";
    // orderItemDetail.itemName ="MarieBiscuit";
    // orderItemDetail.retailPrice =200;

    this.itemPrice = orderItemDetail.retailPrice;
    orderListDetail.qty = this.qty;
    orderListDetail.price = this.itemPrice = +this.itemPrice * +this.qty;

    orderListDetail.item = orderItemDetail;

    // console.log("HHFHDHD"+orderListDetail.item.itemQtyOnHand);
    // console.log("KKKKKKSDSDS"+this.qty);
    //
    this.updateItemQty =  orderListDetail.item.itemQtyOnHand - this.qty;
    orderListDetail.item.itemQtyOnHand = this.updateItemQty;

    if (this.qty!=null) {
      this.orderList.push(orderListDetail);
      this.totalPrice = +this.totalPrice + +this.itemPrice;
    }else{
      alert('Order Qty NULL')
    }

    console.log(this.orderList);

  }



  addCustomerOrder(){
    this.addCusOrder = new CustomerOrder();

    this.addCusOrder.date = this.curDate;
    this.addCusOrder.discount = this.discount=10;
    this.addCusOrder.totalPrice = this.totalPrice;

    this.Cusdetail = new Customer();
    this.Cusdetail.cusID = this.customerId;

    this.addCusOrder.customer = this.Cusdetail;
    this.addCusOrder.customerOrderDetailSet = this.orderList;
    this.addCusOrder.customerOrderDetailSet[0];

    if (this.addCusOrder.customerOrderDetailSet!=null && this.addCusOrder.totalPrice!=0) {
      this.customerOrderService.addCustomerOrder(this.addCusOrder).subscribe((result) => {

        if (result != null) {
          alert('Order Added SuccessFully')
          window.location.reload();
          this.addCusOrder = new CustomerOrder();
          this.Cusdetail = new Customer();
          console.log(this.CusOrder);
        }
      });
    }else{
      alert('Order is NULL')
    }

  }


  searchItemByNameOrId(event: any){

    console.log('item'+this.itemName);

    if(this.searchitembynameOrId.length!=0){
      this.customerOrderService.searchItemDetailsByBarcode(this.searchitembynameOrId).subscribe((result)=>{

        if(result==null){
          this.searchItemValuesIf=true;
          console.log('Result'+result);
        }else{

          this.searchItemValuesIf=false;


          this.searchItemDetails=result;
          //this.searchItemDetails.push(result);
          console.log(this.searchItemDetails);
        }
      });
    }else{
      this.searchItemValuesIf=true;
      //console.log('item'+this.searchItemDetails);
    }
  }


  deleteRow(id){
    for(let i = 0; i < this.orderList.length; ++i){
      if (this.orderList[i].item.barCode === id) {
        this.orderList.splice(i,1);
        this.totalPrice = this.totalPrice - this.itemPrice;
      }
    }
  }


  removeCustomer(){
      this.customerId = null;
  }


}
