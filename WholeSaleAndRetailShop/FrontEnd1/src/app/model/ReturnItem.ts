import {CustomerOrder} from "./CustomerOrder";

export class ReturnItem {
  retItemId : number;
  retItemBarcode:string;
  retDate: string;
  retItemName: string;
  retQuant: number;
  resellableQuant: number;
  notresellableQuant: number;

  customerOrder : CustomerOrder;
}
