package com.zilvinasTamosaitis.furnitureWebStore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String category;
    private int type;
    private String make;
    private float price;


    @Column(columnDefinition = "text")
    private String description;

    public Product() {
        this.id = id;
        this.title = title;
        this.category = category;
        this.type = type;
        this.make = make;
        this.price = price;
        this.description = description;
    }
}
