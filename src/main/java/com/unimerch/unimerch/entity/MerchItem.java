package com.unimerch.unimerch.entity;

import jakarta.persistence.*;
import com.unimerch.unimerch.enums.Color;
import com.unimerch.unimerch.enums.MerchCategory;

@Entity
public class MerchItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String size;
    int quantity;
    int price;

    String name;

    @Enumerated(EnumType.STRING)
    MerchCategory category;

    @Enumerated(EnumType.STRING)
    Color color;

    public MerchItem() {
    }

    public MerchItem(Long id, String size, int quantity, int price, String name, MerchCategory category, Color color) {
        this.id = id;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.category = category;
        this.color = color;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MerchCategory getCategory() {
        return category;
    }

    public void setCategory(MerchCategory category) {
        this.category = category;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}




