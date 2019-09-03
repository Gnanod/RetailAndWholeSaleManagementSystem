import { Injectable } from '@angular/core';
import {Item} from "../model/Item";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {applySourceSpanToExpressionIfNeeded} from "@angular/compiler/src/output/output_ast";


const URL ='/BarcodeGenerateController'

@Injectable({
  providedIn: 'root'
})
export class BarcodeService {

  constructor(private http:HttpClient) { }

  getBarcodes(barcode: string, barcodeQuantity: number) {

    console.log("PPPP"+barcode)
    console.log("PPPP"+barcodeQuantity)
    return this.http.get<String>(environment.backend_url + URL + '/getBarcodeNumbers/'+barcode+'/'+barcodeQuantity);

  }
}
