import {Customer} from "./Customer";
import {CustomerOrderDetail} from "./CustomerOrderDetail";

export class CustomerOrder {
    customerOrderId :Number;
    date : Date;
    totalPrice : Number;
    discount : number;
    customer :Customer;


    customerOrderDetailSet :Array<CustomerOrderDetail>;





}



