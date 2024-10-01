package com.unimerch.unimerch.service;

import com.unimerch.unimerch.enums.MerchCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import com.unimerch.unimerch.entity.MerchItem;
import com.unimerch.unimerch.repository.MerchItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchItemService {

    @Autowired
    private MerchItemRepository merchItemRepository;

    //Method for getting or listing all merchandise items
    public List<MerchItem> getAllMerchItems() {

        return merchItemRepository.findAll();
    }

    //Method for getting merchandise item by id
    public Optional<MerchItem> getMerchItemById(Long id) throws ChangeSetPersister.NotFoundException {

        return Optional.ofNullable(merchItemRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    //Method for getting merchandise item by category
    public List<MerchItem> getAllMerchItemByCategory(MerchCategory category)
    {
        return merchItemRepository.findByCategory(category);
    }
    //Method for getting merchandise item by size
    public List<MerchItem> getAllMerchItemBySize(String size)
    {
        return merchItemRepository.findBySize(size);
    }

    //Method for getting merchandise item by color
    public List<MerchItem> getAllMerchItemByColor(String color)
    {
        return merchItemRepository.findByColor(color);
    }

    // Method for adding merchandise items
    public List<MerchItem> addingAllMerchItems(List<MerchItem> merchItems) {
        System.out.println("Items to save: " + merchItems);
        return merchItemRepository.saveAll(merchItems);
    }

    // Method for adding merchandise item by id
    public MerchItem createMerchItem(MerchItem merchItem) {
        return merchItemRepository.save(merchItem);
    }

}
