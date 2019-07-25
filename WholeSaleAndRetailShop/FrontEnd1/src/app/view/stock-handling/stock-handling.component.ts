import { Component, OnInit } from '@angular/core';
import {Brand} from "../../model/Brand";
import {BrandService} from "../../service/brand.service";
import {Item} from "../../model/Item";
import {ItemService} from "../../service/item.service";
import {StockItemDetails} from "../../model/StockItemDetails";

@Component({
  selector: 'app-stock-handling',
  templateUrl: './stock-handling.component.html',
  styleUrls: ['./stock-handling.component.css']
})
export class StockHandlingComponent implements OnInit {

  constructor(private brandService :BrandService,private itemService :ItemService) { }

  ngOnInit() {
    this.getAllBrands();
  }

  addbrand :Brand = new Brand();
  brands :Array<Brand> = new Array<Brand>();
  selectedBrand :Brand = new Brand();
  additem :Item = new Item();
  searchItemValuesIf = true;
  searchItemDetails:Array<Item> = new Array<Item>();
  searchitembyname:string;
  seachItemBarcode :string;
 
  
  //Store Item Details To The System
  itemName :string;
  itemBuyingPrice :string;
  itemDetailsQtyOnHand :string;
  itemDetailsObject :Item = new Item();
  buyingPrices :Number;
    itemQuantity :Number;
  
  
  //addTo Table Array
    itemsTables :Array<StockItemDetails>=  new Array<StockItemDetails>();
    
    
    addBrand(){
      // console.log('Brand'+this.addbrand.brandName);

        this.brandService.addBrand(this.addbrand).subscribe((result)=>{
            
              if(result!=null){
                  
                  alert('Brand Added SuccessFully')
                  this.addbrand = new Brand();
                  this.getAllBrands();
                  
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
        this.itemService.searchItemDetailsByBarcode(this.seachItemBarcode).subscribe((result)=>{
            if(result!=null){
               
                // this.itemDetailsObject=result;
                
            }
        })
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
        
      let stockItemDetails :StockItemDetails = new StockItemDetails();
      
      stockItemDetails.item=this.itemDetailsObject;
      stockItemDetails.buyingPrice = this.buyingPrices;
      stockItemDetails.quantity=this.itemQuantity;
      
      this.itemsTables.push(stockItemDetails);
        
     
       
        
        
    }
}
