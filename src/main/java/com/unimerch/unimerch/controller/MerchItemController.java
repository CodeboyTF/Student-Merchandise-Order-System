package com.unimerch.unimerch.controller;

import com.unimerch.unimerch.entity.MerchItem;
import com.unimerch.unimerch.enums.MerchCategory;
import com.unimerch.unimerch.service.MerchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/merch")
public class MerchItemController {

    @Autowired
    private MerchItemService merchItemService;

    @GetMapping("/all")
    public List<MerchItem> getAllMerchItems()
    {
        return merchItemService.getAllMerchItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MerchItem>> getMerchItemsById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Optional<MerchItem> merchItem = merchItemService.getMerchItemById(id);
        return new ResponseEntity<>(merchItem, HttpStatus.OK);
    }

    @GetMapping("/category")
    public List<MerchItem> getMerchItemsByCategory(MerchCategory category){
        return merchItemService.getAllMerchItemByCategory(category);
    }

    @PostMapping("/create")
    public MerchItem createMerchItem(@RequestBody MerchItem merchItem) {
        return merchItemService.createMerchItem(merchItem);
    }

    @PostMapping("/addAll")
    public List<MerchItem> addMerchItems(@RequestBody List<MerchItem> merchItems) {
        return merchItemService.addingAllMerchItems(merchItems);
    }
     @PutMapping("/update/{id}")
    public ResposnseEntity
}
