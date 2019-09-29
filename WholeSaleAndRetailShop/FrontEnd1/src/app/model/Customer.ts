import {CustomerOrder} from "./CustomerOrder";

export class Customer{
  cusID:number;
   firstName:String;
  lastName:String;
  userName:String;
  address:String;
  nic:String;
  phone:String;
  email:String;
  birthday:String;
  type:String;
  aboutCus:String;

  ordersList :CustomerOrder;
}
