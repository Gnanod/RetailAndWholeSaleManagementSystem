import {Supplier} from "./Supplier";
import {SupplierOrderDetail} from "./SupplierOrderDetail";

export class SupplierOrder {


  supplierOrderId: String;
  companyName: string;
  total: number;
  status: string;
  supplier: Supplier;
  supplierOrderDetails: Array<SupplierOrderDetail>;
  date : string;

}
