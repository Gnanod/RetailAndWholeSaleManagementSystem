package lk.whsars.service.impl;

import lk.whsars.entity.IdEntity;
import lk.whsars.repository.IdRepository;
import lk.whsars.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdServiceImpl implements IdService {

    @Autowired
    private IdRepository idRepository;

    @Override
    public String getResult() {
        Object lastId =idRepository.getLastId();
//        System.out.println("lastId "+idRepository.getLastId());
//        System.out.println("lastId Null"+idRepository.getLastId().toString());
       if(lastId!=null){
           return lastId.toString();
       }else{
           return null;
       }
        
        
    }
}
