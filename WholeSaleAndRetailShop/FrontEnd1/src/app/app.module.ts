import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './view/main/main.component';
import { EmployeeComponent } from './view/employee/employee.component';
import { DashboardComponent } from './view/dashboard/dashboard.component';

import { SupplierOrderComponent } from './view/supplier-order/supplier-order.component';
import { SupplierOrderAgentItemComponent } from './view/supplier-order-agent-item/supplier-order-agent-item.component';

import { SalaryComponent } from './view/salary/salary.component';

import { AttendanceComponent } from './view/attendance/attendance.component';
import { SalarysheetComponent } from './view/salarysheet/salarysheet.component';
import {StockItemDetails} from "./model/StockItemDetails";
import {CustomerComponent} from "./view/customer/customer.component";
import {StockHandlingComponent} from "./view/stock-handling/stock-handling.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    EmployeeComponent,
    DashboardComponent,
    SupplierOrderComponent,
    SupplierOrderAgentItemComponent,
    SalaryComponent,
    AttendanceComponent,
    SalarysheetComponent,
      CustomerComponent,
      StockHandlingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
      BrowserAnimationsModule,
      AppRoutingModule,
      FormsModule,
      HttpClientModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
