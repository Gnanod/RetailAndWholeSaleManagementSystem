import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Employee} from "../model/Employee";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";


const URL ='/EmployeeController'

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  addEmployee(emp: Employee) {
    return this.http.post<Employee>(environment.backend_url+ URL + '/addEmployee',emp);

  }

  getAllEmployee():Observable<Array<Employee>>{

    return this.http.get<Array<Employee>>(environment.backend_url + URL + '/getAllEmployee');

  }

  deleteEmployee(employee_id: number) {

    return this.http.delete<number>(environment.backend_url + URL + '/deleteEmployee/'+employee_id);

  }


  UpdateEmployeeDetails(UpdateEmployeeDetails: Employee) {

    return this.http.post<Employee>(environment.backend_url + URL + '/updateEmployee',UpdateEmployeeDetails);

  }


  searchEmployeeName(sEmp : string) {
    return this.http.get<Employee>(environment.backend_url + URL + '/searchByEmployeeName/'+sEmp);

  }

  getSalaryDetails(){
    return this.http.get<Array<Employee>>(environment.backend_url+URL+'getempsalary');
  }
}


