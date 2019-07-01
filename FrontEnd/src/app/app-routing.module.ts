import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainComponent} from "./view/main/main.component";
import {EmployeeComponent} from "./view/employee/employee.component";

const routes: Routes = [

    {
        path: 'main',
        component: MainComponent,
        children: [
            {
                path: 'employee',
                component: EmployeeComponent
            }
        ]
    },
    {path: '', pathMatch: "full", redirectTo: '/main/employee'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
