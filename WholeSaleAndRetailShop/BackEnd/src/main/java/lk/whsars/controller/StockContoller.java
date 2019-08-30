package lk.whsars.controller;


import lk.whsars.entity.Item;
import lk.whsars.entity.Stock;
import lk.whsars.entity.StockItemDetails;
import lk.whsars.entity.Supplier;
import lk.whsars.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping(value = "/StockController")
public class StockContoller {

    @Autowired
    private StockService stockService;
    @PostMapping(value = "/addStock")
    public Stock addStock(@RequestBody Stock stock){

        System.out.println("////////////////Item Details ////////////////////////");

        for (StockItemDetails s:stock.getStockItemDetails()) {

            System.out.println("Barcode :"+s.getItem().getBarCode());
            System.out.println("BrandName :"+s.getItem().getBrand().getBrandName());
            System.out.println("ItemName :"+s.getItem().getItemName());
            System.out.println("Item Qty On Hand :"+s.getItem().getItemQtyOnHand());
            System.out.println("Whole Sale Price :"+ s.getItem().getWholeSalePrice());
            System.out.println("Retail Price :"+s.getItem().getRetailPrice());
            System.out.println(s.getBuyingPrice());
            System.out.println(s.getQuantity());
        }

        System.out.println(stock.getDate());
        System.out.println("Stock Date"+stock.getDate());
        System.out.println("Stock Payment"+stock.getPayment());
        System.out.println("Stock Supplier "+stock.getSupplier().getSupplierNic());



        return  stockService.addStock(stock);

    }
}
