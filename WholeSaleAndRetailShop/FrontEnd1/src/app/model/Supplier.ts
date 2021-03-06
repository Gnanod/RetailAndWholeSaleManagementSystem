import {SupplierOrder} from "./SupplierOrder";
import {Stock} from "./Stock";

export class Supplier {

  supplierNic:string;
  supplierName:string;
  address:string;
  email:string;
  phone:string;
  fax:string;
  supplierOrders:Array<SupplierOrder>
  stock : Array<Stock>
  supplierId: number;
  companyName:string;
  date:string;

}
