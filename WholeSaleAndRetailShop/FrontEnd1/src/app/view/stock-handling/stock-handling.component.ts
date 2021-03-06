import { Component, OnInit } from '@angular/core';
import {Brand} from "../../model/Brand";
import {BrandService} from "../../service/brand.service";
import {Item} from "../../model/Item";
import {ItemService} from "../../service/item.service";
import {StockItemDetails} from "../../model/StockItemDetails";
import {Stock} from "../../model/Stock";
import {DatePipe} from "@angular/common";
import {Supplier} from "../../model/Supplier";
import {StockService} from "../../service/stock.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BarcodeService} from "../../service/barcode.service";
import {Company} from "../../model/Company";
import {SupplierOrderService} from "../../service/supplier-order.service";

@Component({
  selector: 'app-stock-handling',
  templateUrl: './stock-handling.component.html',
  styleUrls: ['./stock-handling.component.css']
})
export class StockHandlingComponent implements OnInit {

  constructor(private brandService :BrandService,private itemService :ItemService,private datePipe: DatePipe,private stockService:StockService,private barcodeService:BarcodeService,private make_company : SupplierOrderService,private supplierService:SupplierOrderService) { }


  form = new FormGroup({
    brandname:new FormControl('',Validators.required)
  });

  form1 = new FormGroup({
    itemname:new FormControl('',Validators.required),
    stockLevel:new FormControl('',Validators.required),

  });
  // form1 = new FormGroup({
  //   ItemName :new FormControl('',Validators.required),
  // });
  // form2 = new FormGroup({
  //   itemQty :new FormControl('',Validators.required),
  // });

  // form2 = new FormGroup({
  //   barcode : new FormControl('',Validators.required),
  //   tableItemName : new FormControl('',Validators.required),
  //   buyingPrice : new FormControl('',Validators.required),
  //   wholePrice : new FormControl('',Validators.required),
  //   retailPrice : new FormControl('',Validators.required),
  //   itemQty : new FormControl('',Validators.required)
  // });

  ngOnInit() {
    this.getAllBrands();
    this.getAllCompanies();
  }

  //getCompanyDetails
  selectedCompany : Company = new Company();
  companies :Array<Company> = new Array<Company>();
  insertCompany:string;
  searchMakesByCompany: Array<Supplier> = new Array<Supplier>();
  selectedAgentNic :Supplier = new Supplier();

  getMakeCompanyDetails(value :string){

    this.make_company.getAgentDetails(this.insertCompany).subscribe(result=>{

      if(result!=null){


        this.searchMakesByCompany=result;
        this.selectedAgentNic=this.searchMakesByCompany[0];
        //console.log(" this.selectedAgentNic"+ result[0].company)
      }
    });
  }

  getAllCompanies() {

    console.log(this.insertCompany);
    this.supplierService.getAllCompany().subscribe((result) => {
      this.companies = result;
      //  this.insertCompany=this.companies[0].companyName;
    });

  }


  //DatePipe


  addbrand :Brand = new Brand();
  brands :Array<Brand> = new Array<Brand>();
  selectedBrand :Brand = new Brand();
  additem :Item = new Item();
  searchItemValuesIf = true;
  searchItemDetails:Array<Item> = new Array<Item>();
  searchitembyname:string;
  seachItemBarcode :string;

  //Get Totato Amount
  totAmount : number=0;

  //Store Item Details To The System


  //Search Item Details By Barcode
  searchItemName :string;
  searchBuyingPrice :string;
  searchWholeSalePrice :string;
  searchRetailPrice :string;
  itemDetailsQtyOnHand :string;
  itemQuantity :string;
  itemQuantityOnHand:string;


  itemDetailsObject :Item = new Item();
  buyingPrices :number;


  
  //addTo Table Array
    itemsTables :Array<StockItemDetails>=  new Array<StockItemDetails>();

    //getTotalQunatity

    quantity :number

    
    
    addBrand(){
      // console.log('Brand'+this.addbrand.brandName);

        this.brandService.addBrand(this.addbrand).subscribe((result)=>{
            
              if(result!=null){
               var  textboxes = document.getElementById("itemNameId");

                  alert('Brand Added SuccessFully')
                 // this.addbrand = new Brand();
                this.addbrand.brandName = null;
                  this.getAllBrands();

                var element = document.getElementById("brandNameId");
                element.classList.remove("is-invalid");
                  textboxes.focus();
              }
        });
    
    }
    
    addItem(){
     // this.additem.barCode="000000001";
      this.additem.brand=this.selectedBrand;
      this.itemService.addItem(this.additem).subscribe((result)=>{
        
        if(result!=null){
          alert('Item Added SuccessFully');
          this.additem = new Item();
            this.additem.brand= new Brand();
            
        }
      });
    }

    getAllBrands() {
        this.brandService.getAllBrands().subscribe((result) => {
            this.brands = result;
            this.selectedBrand = result[0];
        });

    }

    searchItemDetailsByBarcode(event :any){


      if(this.seachItemBarcode.length!=0){
        this.itemService.searchItemDetailsByBarcode(this.seachItemBarcode).subscribe((result)=>{
          if(result!=null){

            this.itemDetailsObject=result;
            this.searchItemName =this.itemDetailsObject.itemName;
            this.itemDetailsQtyOnHand =this.itemDetailsObject.itemQtyOnHand.toString();

            // var element = document.getElementById("brandNameId");
            // element.classList.remove("is-invalid");
            var  buyPrice = document.getElementById("buyPrice")
            buyPrice.focus();

          }else{
            console.log(" this.itemDetailsObject"+ this.itemDetailsObject);
            this.itemDetailsObject=new Item();
            this.searchItemName = null;
            this.itemDetailsQtyOnHand=null;
          }
        })
      }else{
        this.searchItemName = null;
        this.itemDetailsQtyOnHand=null;
      }

    }

    searchItemByName(event: any){
        if(this.searchitembyname.length!=0){
            this.itemService.searchItemDetailsByName(this.searchitembyname).subscribe((result)=>{

                if(result==null){
                    this.searchItemValuesIf=true;
                    console.log('Result'+result);
                }else{
                    this.searchItemValuesIf=false;
                    this.searchItemDetails=result;

                }
            });
        }else{

            this.searchItemValuesIf=true;
            // this.searchItemDetails=new Array<Item>();
        }
        
        
    }

    addToTable(){





      if(this.seachItemBarcode !=null && this.searchItemName!=null && this.searchBuyingPrice!=null && this.searchWholeSalePrice != null && this.searchRetailPrice !=null && this.itemDetailsQtyOnHand !=null && this.itemQuantity!=null ) {


        // for(let i = 0; i <  this.itemsTables.length; ++i){
        //   if ( this.itemsTables[i].item.barCode === this.seachItemBarcode ) {
        //
        //     this.itemsTables[i].buyingPrice=parseFloat(this.searchBuyingPrice);
        //     this.itemsTables[i].quantity
        //
        //   }else{
        //
        //     let stockItemDetails: StockItemDetails = new StockItemDetails();
        //     this.itemDetailsObject.barCode = this.seachItemBarcode;
        //     this.itemDetailsObject.retailPrice = parseFloat(this.searchRetailPrice);
        //     this.itemDetailsObject.wholeSalePrice = parseFloat(this.searchWholeSalePrice);
        //     // this.itemDetailsObject.buyingPrice = this.searchBuyingPrice;
        //     console.log("Buying price 8888888888888:"+this.searchBuyingPrice);
        //     // console.log("Buying price1111 :"+ this.itemDetailsObject.buyingPrice);
        //     this.itemDetailsObject.itemName = this.searchItemName;
        //
        //
        //     let totalQuantityOnHand: number;
        //     totalQuantityOnHand = parseInt(this.itemQuantity) + parseInt(this.itemDetailsQtyOnHand);
        //     this.itemDetailsObject.itemQtyOnHand = totalQuantityOnHand;
        //     stockItemDetails.quantity = parseInt(this.itemQuantity);
        //     stockItemDetails.item = this.itemDetailsObject;
        //     stockItemDetails.buyingPrice= parseFloat(this.searchBuyingPrice);
        //
        //     let amount :number;
        //     amount = this.totAmount+(stockItemDetails.buyingPrice*stockItemDetails.quantity);
        //     let stringAmount :string=amount.toString();
        //     this.totAmount=parseFloat(stringAmount);
        //
        //     if (this.seachItemBarcode != null && this.searchItemName != null && this.searchBuyingPrice != null && this.searchWholeSalePrice != null && this.searchRetailPrice != null && this.itemDetailsQtyOnHand != null && this.itemQuantity != null) {
        //
        //       this.itemsTables.push(stockItemDetails);
        //       this.searchItemName = null;
        //       this.searchBuyingPrice = null;
        //       this.searchWholeSalePrice = null;
        //       this.searchRetailPrice = null;
        //       this.itemDetailsQtyOnHand = null;
        //       this.seachItemBarcode = null;
        //       this.itemQuantity = null;
        //
        //
        //
        //     }
        //   }
        // }

        let stockItemDetails: StockItemDetails = new StockItemDetails();
        this.itemDetailsObject.barCode = this.seachItemBarcode;
        this.itemDetailsObject.retailPrice = parseFloat(this.searchRetailPrice);
        this.itemDetailsObject.wholeSalePrice = parseFloat(this.searchWholeSalePrice);
       // this.itemDetailsObject.buyingPrice = this.searchBuyingPrice;
        console.log("Buying price 8888888888888:"+this.searchBuyingPrice);
       // console.log("Buying price1111 :"+ this.itemDetailsObject.buyingPrice);
        this.itemDetailsObject.itemName = this.searchItemName;


        let totalQuantityOnHand: number;
        totalQuantityOnHand = parseInt(this.itemQuantity) + parseInt(this.itemDetailsQtyOnHand);
        this.itemDetailsObject.itemQtyOnHand = totalQuantityOnHand;
        stockItemDetails.quantity = parseInt(this.itemQuantity);
        stockItemDetails.item = this.itemDetailsObject;
        stockItemDetails.buyingPrice= parseFloat(this.searchBuyingPrice);

        let amount :number;
        amount = this.totAmount+(stockItemDetails.buyingPrice*stockItemDetails.quantity);
        let stringAmount :string=amount.toString();
        this.totAmount=parseFloat(stringAmount);

        if (this.seachItemBarcode != null && this.searchItemName != null && this.searchBuyingPrice != null && this.searchWholeSalePrice != null && this.searchRetailPrice != null && this.itemDetailsQtyOnHand != null && this.itemQuantity != null) {

          this.itemsTables.push(stockItemDetails);
          this.searchItemName = null;
          this.searchBuyingPrice = null;
          this.searchWholeSalePrice = null;
          this.searchRetailPrice = null;
          this.itemDetailsQtyOnHand = null;
          this.seachItemBarcode = null;
          this.itemQuantity = null;
        }
      }
    }

  deleteRow(id){
    for(let i = 0; i < this.itemsTables.length; ++i){
      if (this.itemsTables[i].item.barCode === id) {
        this.itemsTables.splice(i,1);

      }
    }
  }

  addStock(){

      let stock:Stock = new Stock();
      stock.date=this.datePipe.transform(new Date(), 'yyyy-MM-dd');
      stock.stockItemDetails=this.itemsTables;
      stock.stockItemDetails=this.itemsTables;
      stock.payment=this.totAmount;

      let sup :Supplier  = new Supplier();
      sup= this.selectedAgentNic;
      console.log("JJJJKK"+this.selectedAgentNic.supplierId)
     // sup.supplierNic='951960055V'
     //  sup.supplierId=2;
      stock.supplier=sup;
      stock.stockItemDetails=this.itemsTables;


      if(this.itemsTables.length==0){
        alert('Please Add Items To Table')
      }else{
        this.stockService.addStock(stock,this.itemsTables).subscribe((result)=>{

          if(stock!=null){
            alert('Added Successfully');
            this.itemsTables = new Array<StockItemDetails>();
          }else{
            alert('Added Fail');
          }

        });
      }

  }


 // barcodeQuantity:number;

  printBarcode(barcode,barcodeQuantity){



    this.barcodeService.getBarcodes(barcode,barcodeQuantity).subscribe((result) => {

      if(result!=null){
        alert('Barcode Document Is Created')
      }

    });
  }


  deleteBrand(brandId: number) {

      console.log('BrandId'+brandId)
    this.brandService.deleteBrand(brandId).subscribe((result) => {

      if(result!=null){
        alert('Brand Is Added');
      }

    });

  }
}
