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


  searchItemValuesIf = true;
  searchItemDetails:Array<Item> = new Array<Item>();
  searchitembyname:string;
  searchitembyid:string;

  Cusdetail :Customer = new Customer();

  addCusOrder :CustomerOrder = new CustomerOrder();
  CusOrder :Array<CustomerOrder> = new Array<CustomerOrder>();

  orderCusDetail : CustomerOrderDetail = new CustomerOrderDetail();
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
      // orderItemDetail.itemQty = value.itemQty - +orderListDetail.qty;
    })

    this.itemPrice = orderItemDetail.retailPrice;
    orderListDetail.qty = this.qty;
    orderListDetail.price = this.itemPrice = +this.itemPrice * +this.qty;

    orderListDetail.item = orderItemDetail;

    this.orderList.push(orderListDetail);

    this.totalPrice = +this.totalPrice + +this.itemPrice;

    console.log(this.itemPrice);

  }



  addCustomerOrder(){
    this.addCusOrder = new CustomerOrder();

    this.addCusOrder.date = this.curDate;
    this.addCusOrder.discount = this.discount=10;
    this.addCusOrder.totalPrice = this.totalPrice;

    this.Cusdetail = new Customer();
    this.Cusdetail.cusID= this.Cusdetail.cusID =1;

    this.addCusOrder.customer = this.Cusdetail;
    this.addCusOrder.customerOrderDetailSet = this.orderList;
    this.addCusOrder.customerOrderDetailSet[0];

    this.customerOrderService.addCustomerOrder(this.addCusOrder).subscribe((result)=>{

      if(result!=null){

        alert('Order Added SuccessFully')
        this.addCusOrder = new CustomerOrder();
        this.Cusdetail = new Customer();
        console.log(this.CusOrder);
      }
    });

    this.searchItemDetails.forEach(function (value) {
      // this.orderCusDetail.item.barCode = value.barCode;
      // this.orderCusDetail.item.retailPrice = value.retailPrice;

    })
  }


  searchItemByName(event: any){

    console.log('item'+this.itemName);

    if(this.searchitembyname.length!=0){
      this.itemService.searchItemDetailsByName(this.searchitembyname).subscribe((result)=>{

        if(result==null){
          this.searchItemValuesIf=true;
          console.log('Result'+result);
        }else{
          this.searchItemValuesIf=false;
          this.searchItemDetails=result;
          console.log(this.searchItemDetails);
        }
      });
    }else{
      this.searchItemValuesIf=true;
      //console.log('item'+this.searchItemDetails);
    }
  }
}
