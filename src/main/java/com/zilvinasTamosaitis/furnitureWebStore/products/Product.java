package com.zilvinasTamosaitis.furnitureWebStore.products;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(name = "product",
            sequenceName = "product_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String title;
    private String category;
    private int type;
    private String make;
    private float price;
    @Column(name = "picByte", length = 1000)
    private byte[] picByte;
//    private List<Product> products;

    public Product(String title, String category, int type, String make, float price, String description) {
        this.title = title;
        this.category = category;
        this.type = type;
        this.make = make;
        this.price = price;
        this.picByte = picByte;
    }

    public Product() {

    }
}
