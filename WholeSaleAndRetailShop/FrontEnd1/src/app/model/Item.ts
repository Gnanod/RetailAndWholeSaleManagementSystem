import {Brand} from "./Brand";
import {CustomerOrderDetail} from "./CustomerOrderDetail";
import {SupplierOrderDetail} from "./SupplierOrderDetail";
import {StockItemDetails} from "./StockItemDetails";

export class Item {

    barCode: string;
    itemName: string;
    itemQtyOnHand: number;
    wholeSalePrice: number;
    retailPrice: number;
    brand: Brand;
    customerOrderDetails: Array<CustomerOrderDetail>;
    supplierOrderDetails: Array<SupplierOrderDetail>;
    stockItemDetails: Array<StockItemDetails>;
    barcodeQuantity:number;


}
