import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Stock} from "../model/Stock";
import {environment} from "../../environments/environment";
import {StockItemDetails} from "../model/StockItemDetails";
import {LowStockLevelDTO} from "../DTO/LowStockLevelDTO";



const URL ='/StockController'
@Injectable({
  providedIn: 'root'
})
export class StockService {

  constructor(private http:HttpClient) { }

  addStock(stock: Stock, itemsTables: Array<StockItemDetails>) {

    return this.http.post<String>(environment.backend_url + URL + '/addStock',stock);

  }


  lowStock() {

    return this.http.get<Array<LowStockLevelDTO>>(environment.backend_url + URL + '/getLowStockLevelReport/');

  }

  printReport() {

    return this.http.get<string>(environment.backend_url + URL + '/printReport/');


  }

  printReports(LowStockLevel: Array<LowStockLevelDTO>) {

    return this.http.post<String>(environment.backend_url + URL + '/printReport/',LowStockLevel);


  }
}
