package lk.whsars.controller;


import lk.whsars.Common.LowStockLevelReport;
import lk.whsars.DTO.LowStockLevelDto;
import lk.whsars.entity.Item;
import lk.whsars.entity.Stock;
import lk.whsars.entity.StockItemDetails;
import lk.whsars.entity.Supplier;
import lk.whsars.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping(value = "/StockController")
public class StockContoller {

    @Autowired
    private StockService stockService;

    @PostMapping(value = "/addStock")
    public String addStock(@RequestBody Stock stock){

      return stockService.addStock(stock);

    }

    @GetMapping(value = "/getLowStockLevelReport")
    public List<LowStockLevelDto> getItems(){

        return stockService.getLowStockLevelReport();

    }



    @PostMapping(value = "/printReport")
    public String printReport(@RequestBody ArrayList<LowStockLevelDto> lowStockLevelDto){

        LowStockLevelReport l1 = new LowStockLevelReport();
       l1.generateLowStockLevelPdf(lowStockLevelDto);
        return "9";

    }
}
