package com.unimerch.unimerch.entity;

import jakarta.persistence.*;

import java.util.Date;

import jakarta.persistence.*;

import java.util.Date;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    Long oid;

    Date date;
    int quality;
    double total_price;

    private Long student_id;
}

