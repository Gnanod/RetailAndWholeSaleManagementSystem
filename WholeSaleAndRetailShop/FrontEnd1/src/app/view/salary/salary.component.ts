import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Employee} from "../../model/Employee";

@Component({
  selector: 'app-salary',
  templateUrl: './salary.component.html',
  styleUrls: ['./salary.component.css']
})
export class SalaryComponent implements OnInit {


  constructor(private router:Router ) { }

  ngOnInit() {
  }

  goToPage() {
    this.router.navigate(['/main/salarysheet']);
  }


}
