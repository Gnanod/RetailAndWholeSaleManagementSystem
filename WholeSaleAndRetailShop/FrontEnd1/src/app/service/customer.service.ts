import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Customer} from "../model/Customer";
import {environment} from "../../environments/environment";
import {LowStockLevelDTO} from "../DTO/LowStockLevelDTO";
import {CustomerReportDTO} from "../DTO/CustomerReportDTO";

const URL ='/CustomerController'

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  addCustomer(cust: Customer) {
    return this.http.post<Customer>(environment.backend_url + URL + '/addCustomer',cust);

  }

  CusReport() {

    return this.http.get<Array<CustomerReportDTO>>(environment.backend_url + URL + '/getCusDetail');

  }


  searchCustomerDtails(searchCustomerNIC: String) {

    return this.http.get<Customer>(environment.backend_url +  URL + '/searchByCustomerNIC/' + searchCustomerNIC);
  }


  updateCustomerDetails(UpdateCustomerDetails: Customer) {
    return this.http.post<Customer>(environment.backend_url + URL + '/updateCustomer',UpdateCustomerDetails);
  }

  deleteCustomer(cusID: number) {
    return this.http.delete<number>(environment.backend_url + URL + '/deleteCustomer/' + cusID);
  }

  searchCustomerPoints(searchCustomerID: String) {

    return this.http.get<Customer>(environment.backend_url +  URL + '/searchByCustomerID/' + searchCustomerID);
  }

  updateLoyaltyPoints(updateLoyaltyPoints: Customer) {
    return this.http.post<Customer>(environment.backend_url + URL + '/updateLoyaltyPoints',updateLoyaltyPoints);
  }

  printCustomerReport(CustomerReport: Array<CustomerReportDTO>) {
    return this.http.post<String>(environment.backend_url + URL + '/printCustomerReport/',CustomerReport);

  }
}


