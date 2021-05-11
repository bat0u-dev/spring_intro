package com.roganov.entity;

import javax.persistence.*;

@Entity
@Table (name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(name="title", length = 128)
    private String title;

    @Column(name="price", length = 128)
    private Integer price;

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
