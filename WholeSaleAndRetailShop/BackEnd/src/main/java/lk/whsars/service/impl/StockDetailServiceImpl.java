package lk.whsars.service.impl;

import lk.whsars.entity.StockItemDetails;
import lk.whsars.repository.StockDetailRepository;
import lk.whsars.service.StockDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StockDetailServiceImpl implements StockDetailService {
    
    @Autowired
    private StockDetailRepository stockDetailRepository;

    @Override
    @Transactional
    public StockItemDetails addStockDetails(StockItemDetails stockItemDetails) {
        
        return stockDetailRepository.save(stockItemDetails);
        
    }
}
