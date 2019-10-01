package lk.whsars.service.impl;

import lk.whsars.Common.ReturnItemListDTO;
import lk.whsars.entity.*;
import lk.whsars.repository.ReturnItemRepository;
import lk.whsars.service.ReturnItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReturnItemServiceImpl implements ReturnItemService {
    @Override
    public List<Item> getAllItems(int orderId) {

        return null;

    }

    @Autowired
    private ReturnItemRepository returnItemRepository;

    @Override
    public List<ReturnItemListDTO> searchByOrderId(int orderId) {
        List<Object[]> ob = returnItemRepository.searchItemByOrderId(orderId);

        List<ReturnItemListDTO> l1 = new ArrayList<>();
        System.out.println("LLLL"+l1.size());
        for ( Object o[]: ob
        ) {
            ReturnItemListDTO r1 = new ReturnItemListDTO();

            r1.setItembarcode(o[0].toString());
            r1.setItemname(o[1].toString());
            r1.setQuantity(Integer.parseInt(o[2].toString()));

            System.out.println("KKKK"+r1.getItembarcode());
            l1.add(r1);
        }
        return l1;
    }

    @Override
    public ReturnItem addItem(ReturnItem returnItem) {
        return returnItemRepository.save(returnItem);

    }

    @Override
    public List<ReturnItem> getAllReturnItem() {
        System.out.println("weda");
        return returnItemRepository.findAll();
    }

    @Override
    public List<ReturnItem> getAllReturnItems() {
        List <Object[]> s1 = returnItemRepository.getAllDetails();

        List<ReturnItem> r = new ArrayList<>();
        for (Object o[]:s1
        ) {
            ReturnItem r1 = new ReturnItem();

            r1.setRetItemId(Integer.parseInt(o[0].toString()));
            r1.setRetItemBarcode(o[1].toString());
            r1.setRetDate(o[2].toString());
            r1.setRetItemName(o[3].toString());
            r1.setRetQuant(Integer.parseInt(o[4].toString()));
            r1.setResellableQuant(Integer.parseInt(o[5].toString()));
            r1.setNotresellableQuant(Integer.parseInt(o[6].toString()));

            r.add(r1);
        }

        return r;
    }

    @Override
    public ReturnItem UpdateReturnItem(ReturnItem returnItem) {
        System.out.println("updateweda");
        return returnItemRepository.save(returnItem);
    }

    @Override
    public void deleteReturnEntry(String retItemId) {

        returnItemRepository.deleteById(Integer.parseInt(retItemId));
    }


}
