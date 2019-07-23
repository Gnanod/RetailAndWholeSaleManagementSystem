import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainComponent} from "./view/main/main.component";
import {EmployeeComponent} from "./view/employee/employee.component";
import {DashboardComponent} from "./view/dashboard/dashboard.component";
import {SupplierOrderComponent} from "./view/supplier-order/supplier-order.component";


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
            path:'supplierorder',
            component : SupplierOrderComponent
          },
        ]
    },
    
    {path: '', pathMatch: "full", redirectTo: '/main/dashboard'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
