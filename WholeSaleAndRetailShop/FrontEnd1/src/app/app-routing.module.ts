import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {MainComponent} from "./view/main/main.component";
import {EmployeeComponent} from "./view/employee/employee.component";
import {DashboardComponent} from "./view/dashboard/dashboard.component";
import {SupplierOrderComponent} from "./view/supplier-order/supplier-order.component";
import {SalaryComponent} from "./view/salary/salary.component";

import {AttendanceComponent} from "./view/attendance/attendance.component";

import {StockHandlingComponent} from "./view/stock-handling/stock-handling.component";
import {CustomerComponent} from "./view/customer/customer.component";
import {SupplierOrderAgentItemComponent} from "./view/supplier-order-agent-item/supplier-order-agent-item.component";
import {CustomerOrderComponent} from "./view/customer-order/customer-order.component";
import {SupplierComponent} from "./view/supplier/supplier.component";
import {CompanyComponent} from "./view/company/company.component";
import {ReturnItemsComponent} from "./view/retitems/retitems.component";
import {SupplierOrderReportComponent} from "./view/supplier-order-report/supplier-order-report.component";
import {LowStockLevelComponent} from "./view/low-stock-level/low-stock-level.component";
import {SalarySheetReportComponent} from "./view/salary-sheet-report/salary-sheet-report.component";
import {CustomerOrderReportComponent} from "./view/customer-order-report/customer-order-report.component";
import {EmployeeAttendanceComponent} from "./view/employee-attendance/employee-attendance.component";
import {CustomerReportComponent} from "./view/customer-report/customer-report.component";
import {SupplierReportComponent} from "./view/supplier-report/supplier-report.component";
import {ReturnsReportComponent} from "./view/returns-report/returns-report.component";


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
        path: 'customer',
        component: CustomerComponent
      },
      {
        path: 'retitems',
        component: ReturnItemsComponent
      },
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'supplierorder',
        component: SupplierOrderComponent
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
        path: 'Company',
        component: CompanyComponent
      },
      {
        path: 'supplier',
        component: SupplierComponent
      },
      {
        path: 'SupplierOrderAgent',
        component: SupplierOrderAgentItemComponent
      },
      {
        path: 'SupplierOrderReport',
        component: SupplierOrderReportComponent,
      },{
        path:'LowStockLevel',
        component:LowStockLevelComponent

      },
      {
        path:'SalarySheetReport',
        component:SalarySheetReportComponent

      },
      {
        path:'CustomerOrderReport',
        component:CustomerOrderReportComponent
      },
      {
        path: 'EmployeeAttendance',
        component: EmployeeAttendanceComponent
      },
      {
        path:'CustomerReport',
        component:CustomerReportComponent
      },
      {
        path:'SupplierDetails',
        component:SupplierReportComponent
      },
      {
        path:'ReturnReport',
        component:ReturnsReportComponent
      }

    ]
  },
  {
    path: 'customerorder',
    component: CustomerOrderComponent,
  },

  {path: '', pathMatch: "full", redirectTo: '/main/dashboard'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
