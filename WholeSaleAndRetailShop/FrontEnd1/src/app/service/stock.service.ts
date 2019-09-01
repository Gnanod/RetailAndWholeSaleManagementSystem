import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Stock} from "../model/Stock";
import {environment} from "../../environments/environment";
import {StockItemDetails} from "../model/StockItemDetails";



const URL ='/StockController'
@Injectable({
  providedIn: 'root'
})
export class StockService {

  constructor(private http:HttpClient) { }

  addStock(stock: Stock, itemsTables: Array<StockItemDetails>) {

    return this.http.post<String>(environment.backend_url + URL + '/addStock',stock);

  }


}
