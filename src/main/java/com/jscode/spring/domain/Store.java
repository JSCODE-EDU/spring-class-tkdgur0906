package com.jscode.spring.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    private String phoneNumber;

    @OneToMany(mappedBy = "store")
    private List<ProductEntity> products = new ArrayList<>();

    // 연관관계 메서드
    public void addProduct(ProductEntity product) {
        products.add(product);
        product.setStore(this);
    }


    //생성 메서드
    public static Store createStore(String name, Address address,
                                    String phoneNumber, ProductEntity... products) {
        Store store = new Store();
        store.name = name;
        store.address = address;
        store.phoneNumber = phoneNumber;
        for (ProductEntity product : products) {
            store.addProduct(product);
        }

        return store;
    }
}
