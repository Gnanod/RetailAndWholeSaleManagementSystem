import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Salary} from "../model/Salary";
import {Employee} from "../model/Employee";


const URL = '/salaryController';

@Injectable({
  providedIn:'root'
})
export class SalaryService {


  constructor(private http: HttpClient ){}



}
