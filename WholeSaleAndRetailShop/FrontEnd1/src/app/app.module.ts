import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MainComponent} from './view/main/main.component';
import {EmployeeComponent} from './view/employee/employee.component';
import {DashboardComponent} from './view/dashboard/dashboard.component';

import {SupplierOrderComponent} from './view/supplier-order/supplier-order.component';
import {SupplierOrderAgentItemComponent} from './view/supplier-order-agent-item/supplier-order-agent-item.component';

import {SalaryComponent} from './view/salary/salary.component';

import {AttendanceComponent} from './view/attendance/attendance.component';
import {CustomerComponent} from "./view/customer/customer.component";
import {StockHandlingComponent} from "./view/stock-handling/stock-handling.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";
import {DatePipe} from "@angular/common";
import {CustomerOrderComponent} from './view/customer-order/customer-order.component';
import {ReturnItemsComponent} from './view/retitems/retitems.component';

import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {SupplierComponent} from './view/supplier/supplier.component';
import {CompanyComponent} from './view/company/company.component';
import {SupplierOrderReportComponent} from './view/supplier-order-report/supplier-order-report.component';
import {LowStockLevelComponent} from './view/low-stock-level/low-stock-level.component';
import {SalarySheetReportComponent} from './view/salary-sheet-report/salary-sheet-report.component';
import {CustomerOrderReportComponent} from "./view/customer-order-report/customer-order-report.component";
<<<<<<< HEAD
import {EmployeeAttendanceComponent} from './view/employee-attendance/employee-attendance.component';
import {CustomerReportComponent} from './view/customer-report/customer-report.component';
import {SupplierReportComponent} from './view/supplier-report/supplier-report.component';
=======
import { ReturnsReportComponent } from './view/returns-report/returns-report.component';
import { EmployeeAttendanceComponent } from './view/employee-attendance/employee-attendance.component';
import { CustomerReportComponent } from './view/customer-report/customer-report.component';
import { SupplierReportComponent } from './view/supplier-report/supplier-report.component';
>>>>>>> 85d0f677d5fe10aa017998e75c59af1ac52e08f5

// import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

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
    CustomerComponent,
    StockHandlingComponent,
    CustomerOrderComponent,
    SupplierComponent,
    CompanyComponent,
    ReturnItemsComponent,
    LowStockLevelComponent,
    SalarySheetReportComponent,

    SupplierOrderReportComponent,
    CustomerComponent,
    StockHandlingComponent,
    CustomerOrderComponent,
    SupplierComponent,
    CompanyComponent,
    ReturnItemsComponent,
    LowStockLevelComponent,
    CustomerOrderReportComponent,
    ReturnsReportComponent,
    EmployeeAttendanceComponent,
    CustomerReportComponent,
    SupplierReportComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule, FontAwesomeModule,
    HttpClientModule,
    ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'never'})
  ],
  providers: [
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
