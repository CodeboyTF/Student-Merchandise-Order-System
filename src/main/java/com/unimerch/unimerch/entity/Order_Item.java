package com.unimerch.unimerch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.awt.*;

@Entity
public class Order_Item {

    @Id
    Long oId;

    int quantity;
    Long size_id;
    double tot_price;
    Long merch_id;
    Long order_id;
}
