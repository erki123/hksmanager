package com.example.hksmanager.service;

import com.example.hksmanager.exception.ItemNotFoundException;
import com.example.hksmanager.component.Eshop;
import com.example.hksmanager.repository.EshopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EshopService {

    private final EshopRepository eshopRepo;

    public EshopService(EshopRepository eshopRepo) {
        this.eshopRepo = eshopRepo;
    }

    //Adding new item
    public Eshop addItem(Eshop eshop) {
        eshop.setItemCode(UUID.randomUUID().toString());
        return eshopRepo.save(eshop);
    }

    //Finding all items
    public List<Eshop> findAllItems() {
        return eshopRepo.findAll();
    }

    //Updating item information
    public Eshop updateItem(Eshop eshop) {
        return eshopRepo.save(eshop);
    }

    //Find item by id
    public Eshop findItemById(Long id){
        return eshopRepo.findItemById(id).orElseThrow(
                () -> new ItemNotFoundException("Item by id " + id + "not found")
        );
    }

    //Delete item
    public void deleteItem(Long id) {
        eshopRepo.deleteItemById(id);
    }
}
