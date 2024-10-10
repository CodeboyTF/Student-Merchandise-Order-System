package com.unimerch.unimerch.controller;

import com.unimerch.unimerch.entity.Category;
import com.unimerch.unimerch.entity.MerchItem;
import com.unimerch.unimerch.enums.MerchCategory;
import com.unimerch.unimerch.service.MerchItemService;
import jakarta.transaction.Transactional;
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
    public ResponseEntity<MerchItem> updateMerchItem(
            @PathVariable Long id,
            @RequestBody MerchItem merchItem){

        MerchItem merchItem1 = merchItemService.updateMerchItem(id, merchItem.getPrice(),
                merchItem.getQuantity());
        return ResponseEntity.ok(merchItem1);
     }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMerchItem(@PathVariable Long id) {
        merchItemService.deleteMerchItemById(id);
        return ResponseEntity.noContent().build();
     }
     @Transactional
    @DeleteMapping("/delete/category/{category}")
    public List<MerchItem>deleteByCategory(@PathVariable Category category) {
        System.out.println(category);
        return  merchItemService.deleteByCategory(category);
     }

}
