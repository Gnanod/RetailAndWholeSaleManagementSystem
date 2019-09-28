import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Employee} from "../model/Employee";
import {Attendance} from "../model/Attendance";
import {Salary} from "../model/Salary";



const URL = '/salaryController';

@Injectable({
  providedIn:'root'
})
export class SalaryService {


  constructor(private http: HttpClient ){}

  getEmpDetails(){
    // return this.http.get<Array<Employee>>(environment.backend_url+URL+'/getempdetails');
    return this.http.get<Array<Salary>>(environment.backend_url+URL+'/getempdetails');
  }

  searchById(empId : string){
    return this.http.get<Employee>(environment.backend_url+URL+'/searchById/'+empId);
  }

  addSalary(salary : Salary){
    return this.http.post<Salary>(environment.backend_url+URL+'/addSal',salary);
  }

  salarySum(){
    return this.http.get(environment.backend_url+URL+'/salSum');
  }
}
