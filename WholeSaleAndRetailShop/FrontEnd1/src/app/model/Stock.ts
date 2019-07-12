import {Supplier} from "./Supplier";
import {StockItemDetails} from "./StockItemDetails";

export class Stock {

    stockId :Number;
    date :string;
    payment :Number;
    supplier : Supplier ;
    stockItemDetails : StockItemDetails;
    
}