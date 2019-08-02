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

  searchCustomerValueIf = true;
  searchCustomerDetails :Customer = new Customer();

  updateCustomerDetails :Customer = new Customer();

  searchCustomerNIC : String;

  searchCustomerDetailsByNIC(event: any){
    this.CustomerService.searchCustomerDtails(this.searchCustomerNIC).subscribe((result)=>{

      if(result==null) {
        this.searchCustomerValueIf = true;
      }else{
        this.searchCustomerValueIf = false;
        this.searchCustomerDetails = result;

      }

    });

  }


  addCustomer(){
    let cust: Customer;
    this.CustomerService.addCustomer(this.cust).subscribe((result)=>{

      if(result!=null){
        alert('Customer Added Successfully');

      }


    });
  }

  UpdateCustomerDetails(){
    this.CustomerService.updateCustomerDetails(this.searchCustomerDetails).subscribe((result)=>{

      if(result != null){
        alert("Customer Details Updated Successfully");
      }
    });
  }

  deleteCustomer(){
    this.CustomerService.deleteCustomer(this.searchCustomerDetails.cusID).subscribe((result)=>{

        if(result == null){
          alert('Customer Delete Successfully');
          this.searchCustomerDetails = new Customer();
        }else{
          alert('Customer Delete Fail');
        }
    });
  }

}
