package lk.whsars.repository;

import lk.whsars.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcodeGeneraterRepository extends JpaRepository<Item,String> {


}
