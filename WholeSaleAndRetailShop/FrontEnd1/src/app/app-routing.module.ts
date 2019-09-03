import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainComponent} from "./view/main/main.component";
import {EmployeeComponent} from "./view/employee/employee.component";
import {DashboardComponent} from "./view/dashboard/dashboard.component";
import {SupplierOrderComponent} from "./view/supplier-order/supplier-order.component";
import {SalaryComponent} from "./view/salary/salary.component";

import {AttendanceComponent} from "./view/attendance/attendance.component";
import {SalarysheetComponent} from "./view/salarysheet/salarysheet.component";
import {StockHandlingComponent} from "./view/stock-handling/stock-handling.component";
import {CustomerComponent} from "./view/customer/customer.component";
import {SupplierOrderAgentItemComponent} from "./view/supplier-order-agent-item/supplier-order-agent-item.component";
import {CustomerOrderComponent} from "./view/customer-order/customer-order.component";
import {SupplierComponent} from "./view/supplier/supplier.component";
import {CompanyComponent} from "./view/company/company.component";


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
              path:'customer',
              component:CustomerComponent  
            },
            {
                path: 'dashboard',
                component: DashboardComponent
            },
            {
              path:'supplierorder',
              component : SupplierOrderComponent
            },
            {
                path: 'StockHandling',
                component: StockHandlingComponent
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
              },
          {
            path :'Company',
            component:CompanyComponent

          },
          {
            path :'supplier',
            component:SupplierComponent
          },
          {
            path: 'SupplierOrderAgent',
            component: SupplierOrderAgentItemComponent
          }

        ]
    },
  {
    path:'customerorder',
    component: CustomerOrderComponent,
  },
    
    {path: '', pathMatch: "full", redirectTo: '/main/dashboard'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
