// import { NgModule } from '@angular/core';
// import { Routes, RouterModule } from '@angular/router';
import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {MainComponent} from "./view/main/main.component";
import {EmployeeComponent} from "./view/employee/employee.component";
import {DashboardComponent} from "./view/dashboard/dashboard.component";
import {CustomerComponent} from "./view/customer/customer.component";
import {StockHandlingComponent} from "./view/stock-handling/stock-handling.component";



const routes: Routes = [
    {
        path: 'main',
        component: MainComponent,
        children: [
          {
            path: 'customer',
            component: CustomerComponent
          },
            {
                path: 'employee',
                component: EmployeeComponent
            },
            {
                path: 'dashboard',
                component: DashboardComponent
            },
            {
                path : 'StockManage',
                component:StockHandlingComponent
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
