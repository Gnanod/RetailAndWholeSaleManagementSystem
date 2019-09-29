package lk.whsars.service;

import lk.whsars.DTO.LowStockLevelDto;
import lk.whsars.entity.Stock;

import java.util.List;

public interface StockService {
    String addStock(Stock stock);

    List<LowStockLevelDto> getLowStockLevelReport();
}
