import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Customer} from "../model/Customer";
import {environment} from "../../environments/environment";

const URL ='/CustomerController'

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  addCustomer(cust: Customer) {
    return this.http.post<Customer>(environment.backend_url + URL + '/addCustomer',cust);

  }

  searchCustomerDtails(searchCustomerNIC: String) {

    return this.http.get<Customer>(environment.backend_url +  URL + '/searchByCustomerNIC/' + searchCustomerNIC);
  }


  updateCustomerDetails(searchCustomerDtails: Customer) {
    return this.http.post<Customer>(environment.backend_url + URL + '/updateCustomer',UpdateCustomerDetails);
  }

  deleteCustomer(cusID: number) {
    return this.http.delete<number>(environment.backend_url + URL + '/deleteCustomer/' + cusID);
  }
}


