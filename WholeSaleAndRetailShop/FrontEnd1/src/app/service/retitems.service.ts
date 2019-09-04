import { Injectable } from '@angular/core';
import {Item} from "../model/Item";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {ReturnItemDTO} from "../model/ReturnItemDTO";
import {SupplierOrderDetail} from "../model/SupplierOrderDetail";
import {ReturnItem} from "../model/ReturnItem";
import {Observable} from "rxjs";
import {Employee} from "../model/Employee";

const URL ='/ReturnItemController'

@Injectable({
  providedIn: 'root'
})
export class RetitemsService {
  constructor(private http:HttpClient) { }

  searchRetItemByOrderId(searchOrderId :number) {

    return this.http.get<Array<ReturnItemDTO>>(environment.backend_url + URL + '/searchByOrderId/'+searchOrderId);

  }

  addReturnedItem(returnsAll:ReturnItem){
    return this.http.post<ReturnItem>(environment.backend_url + URL+'/addReturnedItem',returnsAll);
  }

  getAllReturnItems(){
      return this.http.get<Array<ReturnItem>>(environment.backend_url + URL + '/getAllReturnItem');

  }

  UpdateRetDetails(Ret: ReturnItem) {

    return this.http.post<ReturnItem>(environment.backend_url + URL + '/updateReturnItem',Ret);

  }

  deleteReturnEntry(retItemId: number) {
    return this.http.delete<number>(environment.backend_url + URL + '/deleteReturnEntry/'+retItemId);

  }
}
