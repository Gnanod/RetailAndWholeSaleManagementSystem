import {Brand} from "./Brand";
import {CustomerOrderDetail} from "./CustomerOrderDetail";
import {SupplierOrderDetail} from "./SupplierOrderDetail";
import {StockItemDetails} from "./StockItemDetails";

export class Item {

    barCode: string;
    itemName: string;
    itemQtyOnHand: Number;
    wholeSalePrice: Number;
    retailPrice: Number;
    brand: Brand;
    buyingPrice :string;
    customerOrderDetails: Array<CustomerOrderDetail>;
    supplierOrderDetails: Array<SupplierOrderDetail>;
    stockItemDetails: Array<StockItemDetails>;
    
}