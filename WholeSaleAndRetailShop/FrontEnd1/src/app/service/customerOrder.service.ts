import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {CustomerOrder} from "../model/CustomerOrder";
import {Item} from "../model/Item";
import {Brand} from "../model/Brand";
import {CustomerOrderDetail} from "../model/CustomerOrderDetail";

const URL ='/CustomerOrderController'

@Injectable({
  providedIn: 'root'
})
export class CustomerOrderService {

  constructor(private http:HttpClient) { }

  addCustomerOrder(custorder: CustomerOrder) {
    console.log(custorder);
    return this.http.post<string>(environment.backend_url + URL + '/addCustomerOrder',custorder);

  }

  // addCustomerOrderDetail(custorderDetail: CustomerOrderDetail) {
  //   console.log(custorderDetail);
  //   return this.http.post<CustomerOrderDetail>(environment.backend_url + URL + '/addCustomerOrderDetail',custorderDetail);
  //
  // }

  // searchItemDetailsByName(searchitembyname: string) {
  //
  //   return this.http.get<Array<Item>>(environment.backend_url + URL + '/searchItemDetailsByName/'+searchitembyname);
  //
  // }


}
