import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Company} from "../model/Company";
import {environment} from "../../environments/environment";

const URL ='/companyController'


@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http:HttpClient) { }

  addCompany(com:Company){
    console.log("KLLKKK")
    return this.http.post<Company>(environment.backend_url + URL +'/addCompany',com);
  }

  searchCompanyDetails(searchCompanyName:String){
    return this.http.get<Company>(environment.backend_url + URL + '/searchByCompanyName/'+searchCompanyName);
  }

}
