package lk.whsars.repository;

import lk.whsars.entity.StockItemDetails;
import org.dom4j.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDetailRepository extends JpaRepository<StockItemDetails,Integer>{
    
}
