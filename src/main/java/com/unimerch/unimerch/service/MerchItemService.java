package com.unimerch.unimerch.service;

import com.unimerch.unimerch.enums.MerchCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.unimerch.unimerch.entity.MerchItem;
import com.unimerch.unimerch.repository.MerchItemRepository;

@Service
public class
MerchItemService {

    @Autowired
    private MerchItemRepository merchItemRepository;

    public List<MerchItem> getAllMerchItems() {
        return merchItemRepository.findAll();
    }

    public Optional<MerchItem> getMerchItemById(Long id) throws ChangeSetPersister.NotFoundException {
        return Optional.ofNullable(merchItemRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    public List<MerchItem> getAllMerchItemByCategory(MerchCategory category)
    {
        return merchItemRepository.findByCategory(category);
    }

    public List<MerchItem> getAllMerchItemBySize(String size)
    {
        return merchItemRepository.findBySize(size);
    }

    public List<MerchItem> getAllMerchItemByColor(String color)
    {
        return merchItemRepository.findByColor(color);
    }
    public List<MerchItem> addingAllMerchItems(List<MerchItem> merchItems) {
        System.out.println("Items to save: " + merchItems);
        return merchItemRepository.saveAll(merchItems);
    }

    public MerchItem createMerchItem(MerchItem merchItem) {
        return merchItemRepository.save(merchItem);
    }

}
