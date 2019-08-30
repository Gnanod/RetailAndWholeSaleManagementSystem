import { Injectable } from '@angular/core';
import {Item} from "../model/Item";
import {Brand} from "../model/Brand";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";



const URL ='/ItemController'

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http:HttpClient) { }

    addItem(additem: Item) {
    
        return this.http.post<Item>(environment.backend_url + URL + '/AddItem',additem);

    }
    //
    // searchItemDetailsByName() {
    //
    //     return this.http.post<Item>(environment.backend_url + URL + '/AddItem',additem);
    //
    //
    // }
    searchItemDetailsByName(searchitembyname: string) {

        return this.http.get<Array<Item>>(environment.backend_url + URL + '/searchItemDetailsByName/'+searchitembyname);
    
    }

  searchByProductName(searchProductName :string) {

    return this.http.get<Item>(environment.backend_url + URL + '/searchByProductName/'+searchProductName);
  }
}
