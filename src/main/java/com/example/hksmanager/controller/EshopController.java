package com.example.hksmanager.controller;

import com.example.hksmanager.component.Eshop;
import com.example.hksmanager.service.EshopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eshop")
public class EshopController {

    private final EshopService eshopService;

    public EshopController(EshopService eshopService) {
        this.eshopService = eshopService;
    }

    //Read all items
    @GetMapping("/all")
    public ResponseEntity<List<Eshop>> getAllItems() {
        List<Eshop> items = eshopService.findAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    //Find item by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Eshop> getItemByID(@PathVariable("id") Long id) {
        Eshop item = eshopService.findItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    //Add new item
    @PostMapping("/add")
    public ResponseEntity<Eshop> addItem(@RequestBody Eshop item) {
        Eshop newItem = eshopService.addItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    //Update item
    @PutMapping("/update")
    public ResponseEntity<Eshop> updateItem(@RequestBody Eshop item) {
        Eshop updateItem = eshopService.updateItem(item);
        return new ResponseEntity<>(updateItem, HttpStatus.OK);
    }

    // Delete item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") Long id) {
        eshopService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
