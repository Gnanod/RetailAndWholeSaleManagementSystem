import {Item} from "./Item";
import {CustomerOrder} from "./CustomerOrder";

export class CustomerOrderDetail {
    
    customerOrderDetail :number;
    amount :number;
    discount :number;
    customerOrder :CustomerOrder;
    item : Item;
    
}
