package lk.whsars.repository;

import lk.whsars.entity.IdEntity;
import lk.whsars.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IdRepository extends JpaRepository<Item,String> {

    @Query(value = " select bar_code from Item order by 1 desc limit 1",nativeQuery = true)
    Object getLastId();
}
