package com.unimerch.unimerch.entity;

import jakarta.persistence.*;

import com.unimerch.unimerch.enums.Color;
import com.unimerch.unimerch.enums.MerchCategory;

@Entity
public class MerchItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    Long merchId;
    String size;
    int quantity;
    double price;

    String name;

    @Enumerated(EnumType.STRING)
    MerchCategory category;

    @Enumerated(EnumType.STRING)
    Color color;

    //Default Constructor
    public MerchItem() {
    }

    //Constructor with parameters
    public MerchItem(Long merchId, String size, int quantity, double price, String name, MerchCategory category, Color color) {
        this.merchId = merchId;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.category = category;
        this.color = color;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MerchCategory getCategory() {
        return category;
    }

    public void setCategory(MerchCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }
}

