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
}
