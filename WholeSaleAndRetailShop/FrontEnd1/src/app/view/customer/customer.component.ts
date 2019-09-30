import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";
import {Customer} from "../../model/Customer";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {



  // onSubmit(){
  //   alert(JSON.stringify(this.form.value))
  // }

  cust: Customer = new Customer();


  // isValidFormSubmitted: boolean = null;
  form = new FormGroup({
    firstName: new FormControl(' ',Validators.required),
    lastName: new FormControl('',Validators.required),
    userName: new FormControl('',Validators.required),
    address: new FormControl('',Validators.required),
    nic: new FormControl('',Validators.required),
    phone: new FormControl('',Validators.required),
    email: new FormControl('',[Validators.required, Validators.email]),
    birthday: new FormControl('',Validators.required),
   type: new FormControl('', Validators.required),
    aboutCus: new FormControl('',Validators.required)
  })

  // form1 = new FormGroup({
  //   firstName1: new FormControl(' ',Validators.required),
    // lastName1: new FormControl('',Validators.required),
    // userName1: new FormControl('',Validators.required),
    // address1: new FormControl('',Validators.required),
    // nic1: new FormControl('',Validators.required),
    // phone1: new FormControl('',Validators.required),
    // email1: new FormControl('',Validators.required),
    // birthday1: new FormControl('',Validators.required),
    // type1: new FormControl('', Validators.required),
    // aboutCus1: new FormControl('',Validators.required)
  // })

  // onFormSubmit() {
  //   this.isValidFormSubmitted = false;
  //   if(this.form.invalid){
  //     return;
  //   }

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
  cusID : number;
  firstName1 : String;
  lastName1 : String;
  userName1 : String;
  address1 : String;
  nic1 : String;
  phone1 : String;
  email1 : String;
  birthday1 : String;
  type1 : String;
  aboutCus1 : String;
  loyaltyPoints1 : number;

  searchCustomerDetailsByNIC(event: any){

    if(this.searchCustomerNIC.length!=0){
      this.CustomerService.searchCustomerDtails(this.searchCustomerNIC).subscribe((result)=>{

        if(result==null) {
          this.searchCustomerValueIf = true;
        }else{
          this.searchCustomerValueIf = false;

          this.searchCustomerDetails=result;
          this.cusID = this.searchCustomerDetails.cusID
          this.firstName1 = this.searchCustomerDetails.firstName;
          this.lastName1 = this.searchCustomerDetails.lastName;
          this.userName1 = this.searchCustomerDetails.userName;
          this.address1 = this.searchCustomerDetails.address;
          this.nic1 = this.searchCustomerDetails.nic;
          this.phone1 = this.searchCustomerDetails.phone;
          this.email1 = this.searchCustomerDetails.email;
          this.birthday1 = this.searchCustomerDetails.birthday;
          this.type1 = this.searchCustomerDetails.type;
          this.loyaltyPoints1 = this.searchCustomerDetails.loyaltyPoint;
          this.aboutCus1 = this.searchCustomerDetails.aboutCus;

        }

      });
    }


  }


  addCustomer(){
    let cust: Customer;
    this.CustomerService.addCustomer(this.cust).subscribe((result)=>{

      if(result!=null){
        alert('Customer Added Successfully');

      }


    });
  }

  updateCutomer(){

    let  cust :Customer = new Customer();
    cust.cusID = this.cusID;
    cust.firstName=this.firstName1;
    cust.lastName = this.lastName1;
    cust.userName = this.userName1;
    cust.address = this.address1;
    cust.nic = this.nic1;
    cust.phone = this.phone1;
    cust.email = this.email1;
    cust.birthday = this.birthday1;
    cust.type = this.type1;
    cust.aboutCus = this.aboutCus1;




    this.CustomerService.updateCustomerDetails(cust).subscribe((result)=>{

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
