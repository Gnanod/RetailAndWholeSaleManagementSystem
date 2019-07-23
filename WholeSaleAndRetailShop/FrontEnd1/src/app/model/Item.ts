import {Brand} from "./Brand";
import {CustomerOrderDetail} from "./CustomerOrderDetail";
import {SupplierOrderDetail} from "./SupplierOrderDetail";
import {StockItemDetails} from "./StockItemDetails";

export class Item {

    barCode: string;
    itemName: string;
    itemQty: Number;
    wholeSalePrice: Number;
    retailPrice: Number;
    brand: Brand;
    customerOrderDetails: Array<CustomerOrderDetail>;
    supplierOrderDetails: Array<SupplierOrderDetail>;
    stockItemDetails: Array<StockItemDetails>;
}