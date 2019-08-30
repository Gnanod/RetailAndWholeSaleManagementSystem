import {Supplier} from "./Supplier";
import {StockItemDetails} from "./StockItemDetails";

export class Stock {

   stockId :number ;
   date :string;
   payment :number;
   supplier :Supplier;
   stockItemDetails :Array<StockItemDetails>;



}
