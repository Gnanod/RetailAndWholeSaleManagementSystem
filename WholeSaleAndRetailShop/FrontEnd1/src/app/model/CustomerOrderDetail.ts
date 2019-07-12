import {Item} from "./Item";
import {CustomerOrder} from "./CustomerOrder";

export class CustomerOrderDetail {
    
    customerOrderDetail :Number;
    amount :Number;
    discount :Number;
    customerOrder :CustomerOrder;
    item : Item;
    
}