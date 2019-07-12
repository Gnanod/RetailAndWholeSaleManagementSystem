package lk.whsars.controller;



import lk.whsars.entity.StockItemDetails;
import lk.whsars.service.StockDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/StockDetailController")
public class StockDetailController {

    @Autowired
    private StockDetailService stockDetailService;


    @PostMapping(value = "/addStockDetails")
    public StockItemDetails addStockDetails(@RequestBody StockItemDetails stockItemDetails){
        return stockDetailService.addStockDetails(stockItemDetails);
    }
}
