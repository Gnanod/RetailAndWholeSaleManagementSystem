package lk.whsars.service.impl;

import lk.whsars.entity.Brand;
import lk.whsars.entity.Item;
import lk.whsars.repository.BarcodeGeneraterRepository;
import lk.whsars.repository.ItemRepository;
import lk.whsars.service.BarCodeGeneraterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandCodeGeneraterServiceImpl implements BarCodeGeneraterService {


    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getBarcodeNumbers(String barcode) {

        return itemRepository.findAllItemsByBarcodeNotLike(barcode);

    }
}
