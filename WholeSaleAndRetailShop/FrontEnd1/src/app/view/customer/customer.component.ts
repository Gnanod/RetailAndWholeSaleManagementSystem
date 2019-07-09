import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";
import {Customer} from "../../model/Customer";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  cust: Customer = new Customer();

  constructor(private CustomerService: CustomerService, private route: Router ) { }

  GOTOCustomer(){
    this.route.navigate(['/customer'])
  }

  ngOnInit() {
  }

  addCustomer(){
    let cust: Customer;
    this.CustomerService.addCustomer(this.cust).subscribe((result)=>{

      if(result!=null){
        alert('Customer Added Successfully');
      }


    })
  }

}
