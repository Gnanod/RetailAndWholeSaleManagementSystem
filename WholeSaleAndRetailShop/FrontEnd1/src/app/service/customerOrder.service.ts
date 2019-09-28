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

  // searchItemDetailsByNameOrId(searchItemNameOrId: string){
  //
  //   return this.http.get<Array<Item>>(environment.backend_url+URL+'/searchItemDetailsByNameOrId/'+searchItemNameOrId);
  // }

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

  searchItemDetailsByBarcode(searchitembyname: string) {

    return this.http.get<Array<Item>>(environment.backend_url + URL + '/searchItemDetailsByBarcode/'+searchitembyname);

  }

  searchLastOrder() {

    return this.http.get <String>(environment.backend_url + URL + '/searchLastOrder');

  }
  //
  // searchItemDetailsByBarcodef(searchitembyname: string) {
  //
  //   return this.http.get<Array<Item>>(environment.backend_url + URL + '/searchItemDetailsByBarcode/'+searchitembyname);
  // }
  //

  // searchLastCustomerOrder(){
  //   return this.http.get<Array<CustomerOrder>>(environment.backend_url + URL + '/searchItemDetailsByBarcode');
  // }


  lastOrderUndo(lastOrderId:number){
    //console.log(lastOrderId)
    return this.http.delete<number>(environment.backend_url + URL + '/deleteCustomerOrder/'+lastOrderId);
    console.log(lastOrderId)
  }




}
