package lk.whsars.service.impl;

import lk.whsars.entity.Stock;
import lk.whsars.repository.StockRepository;
import lk.whsars.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;


    @Override
   @Transactional
    public Stock addStock(Stock stock) {
        System.out.println("KKKKKKKKKk");
        return stockRepository.save(stock);
    }
}
