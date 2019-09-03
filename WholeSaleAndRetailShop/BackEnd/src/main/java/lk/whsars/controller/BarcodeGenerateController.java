package lk.whsars.controller;


import lk.whsars.Common.BarCode;
import lk.whsars.entity.Item;
import lk.whsars.service.BarCodeGeneraterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/BarcodeGenerateController")
public class BarcodeGenerateController {

    @Autowired
    private BarCodeGeneraterService barcodeServiceGenerater;

    @GetMapping(value = "/getBarcodeGenerater")
    public String getBarcode(){

        BarCode barcode = new BarCode();
        List barcodeList = barcodeServiceGenerater.getAllItems();
        //barcode.generateBarcodePdf(barcodeList);

        return "Success";
    }

    @GetMapping(value = "/getBarcodeNumbers/{barcode}/{quantity}")
    public String getBarcodeNumbers(@PathVariable String barcode,@PathVariable String quantity){


        BarCode barcode1 = new BarCode();
//        List barcodeList = barcodeServiceGenerater.getBarcodeNumbers(barcode);

//        barcode1.generateBarcodePdf(barcodeList);
        System.out.println("oooooooooo"+barcode);
        System.out.println("oooooooooo"+quantity);
        Item barcodeList = barcodeServiceGenerater.getBarcodeNumbers(barcode);

        int itemQty = Integer.parseInt(quantity);

        barcode1.generateBarcodePdf(barcodeList,itemQty);
        System.out.println("ItemListName"+barcodeList.getItemName());

        return "9";
    }

}
