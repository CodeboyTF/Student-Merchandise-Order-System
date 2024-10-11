package com.unimerch.unimerch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    Long cId;
    String items;
}

