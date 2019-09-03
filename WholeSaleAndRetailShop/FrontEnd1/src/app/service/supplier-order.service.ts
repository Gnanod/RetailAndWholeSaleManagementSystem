import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

import {SupplierOrderDetail} from "../model/SupplierOrderDetail";
import {environment} from "../../environments/environment";
import {Company} from "../model/Company";
import {Supplier} from "../model/Supplier";
import {Item} from "../model/Item";
import {SupplierOrder} from "../model/SupplierOrder";
import {SupplierOrderSearchDto} from "../model/SupplierOrderSearchDto";



const URL = '/SupplierOrderController'

@Injectable({
  providedIn: 'root'
})
export class SupplierOrderService {

  constructor(private http:HttpClient) { }

  addMakeCompany(tableMakeCompany:Array<SupplierOrderDetail>){
    return this.http.post<SupplierOrderDetail>(environment.backend_url + URL+"/addMakeCompany",tableMakeCompany);
  }

  getAllCompany(){

    return this.http.get<Array<Company>>(environment.backend_url + URL + '/getAllCompany');

  }

  getCompanyDetails(selectcompany:string){
    return this.http.get<Array<SupplierOrderDetail>>(environment.backend_url+URL+"/getMakeCompany/"+selectcompany);
  }

  getAgentDetails(selectagent:string){
    console.log("GGGHHHHHHJJJJJJJJJJ"+selectagent);
    return this.http.get<Array<Supplier>>(environment.backend_url+URL+"/getMakeAgent/"+selectagent);
  }

  getAllAgent(insertCompany:string){

    return this.http.get<Array<Supplier>>(environment.backend_url + URL + '/getAllSupplier'+insertCompany);

  }

  searchMakeCompanyId(insertCompany:string){
    return this.http.get<string>(environment.backend_url+URL+'/searchMakeCompanyName/'+insertCompany);
  }

  getItemDetails(supplierNic: string) {

    return this.http.get<Array<Item>>(environment.backend_url+URL+'/getItemDetails/'+supplierNic);


  }

  saveJoBOrder(supplierOrder: SupplierOrder) {

    return this.http.post<String>(environment.backend_url+URL+'/saveJoBOrder/',supplierOrder);


  }

  searchOrder(searchOrderId : string){

    return this.http.get<SupplierOrderSearchDto>(environment.backend_url+URL+'/getSupplierOrder/'+searchOrderId);

  }


  updateSupplierOrder(updateStatus: SupplierOrder) {

    return this.http.post<SupplierOrder>(environment.backend_url+URL+'/updateSupplierOrder/',updateStatus);

  }
}

