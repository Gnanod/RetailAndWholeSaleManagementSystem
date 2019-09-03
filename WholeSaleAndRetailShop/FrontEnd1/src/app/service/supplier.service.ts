import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Supplier} from "../model/Supplier";
import {environment} from "../../environments/environment";

const URL = '/supplierController';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  constructor(private http:HttpClient) { }

  addSupplier(sup:Supplier){
    console.log("KLLKKK");
    return this.http.post<Supplier>(environment.backend_url + URL+'/addSupplier',sup);


  }

  searchSupplierDetails(searchSupplierNic:String){
    return this.http.get<Supplier>(environment.backend_url + URL + '/searchBySupplierNic/' + searchSupplierNic);

  }

  updateSupplierDetails(updateSupplierDetails: Supplier){
    return this.http.post<Supplier>(environment.backend_url + URL + '/updateSupplierDetails',updateSupplierDetails);
  }

  deleteSupplier(supplierNic:Supplier){

    console.log("Supplier Details "+supplierNic.supplierNic);
    return this.http.delete<String>(environment.backend_url + URL + '/deleteSupplier/' + supplierNic);
  }

  deleteSuppliers(supplierNic:Supplier){

    console.log("Supplier Details "+supplierNic.supplierNic);

    return this.http.delete<string>(environment.backend_url + URL + '/deleteSupplier/' + supplierNic.supplierId);

  }
}
