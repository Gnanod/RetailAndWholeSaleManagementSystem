import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './view/main/main.component';
import { EmployeeComponent } from './view/employee/employee.component';
import { DashboardComponent } from './view/dashboard/dashboard.component';
import { SalaryComponent } from './view/salary/salary.component';

import { AttendanceComponent } from './view/attendance/attendance.component';
import { SalarysheetComponent } from './view/salarysheet/salarysheet.component';


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    EmployeeComponent,
    DashboardComponent,
    SalaryComponent,

    AttendanceComponent,

    SalarysheetComponent  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
