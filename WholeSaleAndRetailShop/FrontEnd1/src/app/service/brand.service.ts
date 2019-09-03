import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Brand} from "../model/Brand";
import {environment} from "../../environments/environment";

const URL ='/BrandController'
@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private http:HttpClient) { }


    addBrand(addbrand: Brand) {

    console.log('BrandSercice'+addbrand.brandName);
    
        return this.http.post<Brand>(environment.backend_url + URL + '/addBrand',addbrand);


    }

    getAllBrands() {
    
        return this.http.get<Array<Brand>>(environment.backend_url + URL + '/getAllBrand');

    }

  deleteBrand(brandId: number) {

    return this.http.delete<string>(environment.backend_url + URL + '/deleteBrand/'+brandId);

  }
}
