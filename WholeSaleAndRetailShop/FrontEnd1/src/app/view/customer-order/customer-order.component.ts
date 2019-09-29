import { Component, OnInit } from '@angular/core';
import {Item} from "../../model/Item";
import {Customer} from "../../model/Customer";
import {CustomerOrder} from "../../model/CustomerOrder";
import {CustomerOrderDetail} from "../../model/CustomerOrderDetail";
import {CustomerOrderService} from "../../service/customerOrder.service";
import {ItemService} from "../../service/item.service";
import {CustomerService} from "../../service/customer.service";

@Component({
  selector: 'app-customer-order',
  templateUrl: './customer-order.component.html',
  styleUrls: ['./customer-order.component.css']
})
export class CustomerOrderComponent implements OnInit {

  constructor(private customerOrderService :CustomerOrderService, private customerService:CustomerService,
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
  lastAmount : number;
  totalPrice : number = 0;
  itemPrice:number = 0;
  curDate=new Date();
  customerId : number = 1;
  itemQtyOnHand : number = 0;
  updateItemQty : number = 0;
  birthday : number;
  points : number = 0;

  searchItemValuesIf = true;
  searchItemDetails:Array<Item> = new Array<Item>();
  searchitembynameOrId:string;

  Cusdetail :Customer = new Customer();
  searchCustomerDetails :Customer = new Customer();
  searchCustomerValueIf = true;

  addCusOrder :CustomerOrder = new CustomerOrder();
  CusOrder :Array<CustomerOrder> = new Array<CustomerOrder>();
  //searchLastOrder:Array<CustomerOrder> = new Array<CustomerOrder>();
  searchLastOrder:CustomerOrder = new CustomerOrder();
  getLastOrderId : number;
  getLastOrdertotal : number;
  getLastOrderdisdount : number=0;

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


    this.itemPrice = orderItemDetail.retailPrice;
    orderListDetail.qty = this.qty;
    orderListDetail.price = this.itemPrice = +this.itemPrice * +this.qty;

    orderListDetail.item = orderItemDetail;

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
    this.addCusOrder.discount = this.discount;
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


    //loyalty points generating
    if(this.lastAmount > 50000){
      this.points = 15;
    }else if(this.lastAmount > 10000){
      this.points = 10;
    }else if(this.lastAmount > 5000){
      this.points = 5;
    }else if(this.lastAmount > 1000){
      this.points = 1;
    }

    this.Cusdetail = new Customer();
    this.Cusdetail = this.searchCustomerDetails;
    this.Cusdetail.phone = this.points.toString();
    this.customerService.updateLoyaltyPoints(this.Cusdetail).subscribe((result) => {

      if (result != null) {
        this.Cusdetail = new Customer();
        console.log(this.Cusdetail);
      }
    });

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
    this.totalPrice = this.lastAmount;
    if(this.totalPrice == this.lastAmount) {
      this.customerId = null;
      this.discount = null;
      this.lastAmount = null;
      console.log('qqqqqqqqqqqqq');
    }

  }


  lastOrderUndo() {

    this.getLastOrderId=11;
    this.customerOrderService.lastOrderUndo(this.getLastOrderId);

    this.customerOrderService.searchLastOrder().subscribe((result)=>{
      //console.log(result);
      if(result==null){
        //console.log('Result'+result);
      }else{
        console.log(result);

        //CustomerOrder c1 = new CustomerOrder();
        //this.getLastOrderId = result;
        //this.getLastOrderId =this.searchLastOrder.customerOrderId;
        //this.searchLastOrder = result;
        //console.log(this.searchLastOrder);
        //this.searchLastOrder.forEach((value)=> {
        //console.log(value);
        //this.getLastOrderId = value.customerOrderId;

        //})
        this.getLastOrderId=3;
        console.log(result)
        if(this.getLastOrderId != null){
          this.customerOrderService.lastOrderUndo(this.getLastOrderId).subscribe();
          alert('Last Order Delete SuccessFully')
        }
      }
    });
  }


  addDiscount(){
    if(this.customerId != 1){
      this.lastAmount = this.totalPrice;

      this.customerService.searchCustomerPoints(this.customerId).subscribe((result)=>{

        if(result==null) {
          this.searchCustomerValueIf = true;
        }else{
          this.searchCustomerValueIf = false;
          this.searchCustomerDetails = result;

          this.birthday = parseInt(this.searchCustomerDetails.birthday.toString());
          console.log('nnnnnnnnnnnnnnnnnnnnnn'+this.birthday);

          if(this.birthday >= 1000){
            this.discount = this.totalPrice * 0.10;
            this.totalPrice = this.totalPrice - this.discount;
          }else if(this.birthday >= 500) {
            this.discount = this.totalPrice * 0.05;
            this.totalPrice = this.totalPrice - this.discount;
          }else if(this.birthday >= 100) {
            this.discount = this.totalPrice * 0.01;
            this.totalPrice = this.totalPrice - this.discount;
          }else if(this.birthday < 100) {
            this.discount = this.totalPrice * 0.005;
            this.totalPrice = this.totalPrice - this.discount;
          }

        }

      });

    }
  }

}
