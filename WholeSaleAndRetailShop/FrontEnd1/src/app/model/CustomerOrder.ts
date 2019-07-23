import {Customer} from "./Customer";
import {CustomerOrderDetail} from "./CustomerOrderDetail";

export class CustomerOrder {
    customerOrderId :Number;
    date : string;
    customer :Customer;
    customerOrderDetailSet :Array<CustomerOrderDetail>;
}