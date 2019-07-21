import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainComponent} from "./view/main/main.component";
import {EmployeeComponent} from "./view/employee/employee.component";
import {DashboardComponent} from "./view/dashboard/dashboard.component";
import {SalaryComponent} from "./view/salary/salary.component";

import {AttendanceComponent} from "./view/attendance/attendance.component";
import {SalarysheetComponent} from "./view/salarysheet/salarysheet.component";


const routes: Routes = [
    {
        path: 'main',
        component: MainComponent,
        children: [
            {
                path: 'employee',
                component: EmployeeComponent
            },
            {
                path: 'dashboard',
                component: DashboardComponent
            },
          {
            path: 'salary',
            component: SalaryComponent
          },
          {
            path: 'attendance',
            component: AttendanceComponent
          },
          {
            path: 'salary/salarysheet',
            component: SalarysheetComponent
          }
        ]
    },
    
    {path: '', pathMatch: "full", redirectTo: '/main/dashboard'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
