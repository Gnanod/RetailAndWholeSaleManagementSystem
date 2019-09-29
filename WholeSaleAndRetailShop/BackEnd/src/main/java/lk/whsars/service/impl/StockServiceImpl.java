package lk.whsars.service.impl;

import lk.whsars.DTO.LowStockLevelDto;
import lk.whsars.entity.Item;
import lk.whsars.entity.Stock;
import lk.whsars.entity.StockItemDetails;
import lk.whsars.repository.ItemRepository;
import lk.whsars.repository.StockRepository;
import lk.whsars.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
   @Transactional
    public String addStock(Stock stock) {

        Stock s1 = stockRepository.save(stock);

        if(s1!=null){
            Set<StockItemDetails> stockItemDetails = stock.getStockItemDetails();
            for (StockItemDetails s2: stockItemDetails
            ) {
                Item i = s2.getItem();
                itemRepository.save(i);
            }

            return "9";
        }else{
            return null;
        }

    }

    @Override
    public List<LowStockLevelDto> getLowStockLevelReport() {


        List<Object[]> lowStock = stockRepository.getLowStockLevelReport();

        List<LowStockLevelDto> d = new ArrayList<LowStockLevelDto>();
        for ( Object ob []: lowStock
        ) {

            LowStockLevelDto d1 = new LowStockLevelDto();

            d1.setBarcode(ob[0].toString());
            d1.setItemName(ob[1].toString());
            d1.setQtyOnHand(Double.parseDouble(ob[2].toString()));
            d1.setBrandName(ob[3].toString());
            d1.setSupplierName(ob[4].toString());
            d1.setCompany(ob[5].toString());

            d.add(d1);

        }


        return d;
    }
}
