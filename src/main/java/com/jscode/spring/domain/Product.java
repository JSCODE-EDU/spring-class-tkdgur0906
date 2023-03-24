package com.jscode.spring.domain;

import lombok.Getter;

@Getter
public class Product {

    private Long id;

    private String name;

    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toStringToDollar() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price / 1300 + "$" +
                '}';
    }

    public String toStringToWon() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
