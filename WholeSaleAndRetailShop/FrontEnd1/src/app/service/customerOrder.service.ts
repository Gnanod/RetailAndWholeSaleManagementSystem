import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {CustomerOrder} from "../model/CustomerOrder";
import {Item} from "../model/Item";
import {LowStockLevelDTO} from "../DTO/LowStockLevelDTO";
import {CustomerOrderReportDTO} from "../DTO/CustomerOrderReportDTO";

const URL = '/CustomerOrderController';

@Injectable({
  providedIn: 'root'
})
export class CustomerOrderService {

  constructor(private http: HttpClient) {
  }

  addCustomerOrder(custorder: CustomerOrder) {
    return this.http.post<string>(environment.backend_url + URL + '/addCustomerOrder', custorder);
  }

  searchItemDetailsByBarcode(searchitembyname: string) {
    return this.http.get<Array<Item>>(environment.backend_url + URL + '/searchItemDetailsByBarcode/' + searchitembyname);
  }

  searchLastOrder() {
    return this.http.get <String>(environment.backend_url + URL + '/searchLastOrder');
  }

  lastOrderUndo(lastOrderId: number) {
    return this.http.delete<number>(environment.backend_url + URL + '/deleteCustomerOrder/' + lastOrderId);
  }

  printReports(CustomerOrderReport: Array<CustomerOrderReportDTO>) {
    return this.http.post<String>(environment.backend_url + URL + '/printReport/',CustomerOrderReport);
  }

  getCustomerOrders() {
    return this.http.get<Array<CustomerOrderReportDTO>>(environment.backend_url + URL + '/getCustomerOrderReport/');
  }

}
