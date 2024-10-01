package com.unimerch.unimerch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.unimerch.unimerch.entity.MerchItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MerchItemRepository extends JpaRepository<MerchItem, Long> {

    List<MerchItem> findByCategory (String category);
    List<MerchItem> findBySize (String size);
    List<MerchItem> findByColor(String color);
}
