package lk.whsars.controller;

import lk.whsars.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;

@CrossOrigin
@RestController
@RequestMapping(value = "/IdContoller")
public class IdController {
    
    @Autowired
    private IdService idService;
    
   public  String getLastID(){

       String lastId = idService.getResult();
       if (lastId != null) {
           
           int id = Integer.parseInt(lastId);
           id++;
           NumberFormat numberFormat = NumberFormat.getIntegerInstance();
           numberFormat.setMinimumIntegerDigits(9);
           numberFormat.setGroupingUsed(false);
           String newID = numberFormat.format(id);
           return newID;
           
       } else {
           
           return  "000000001";
           
       }

       
   }
}

