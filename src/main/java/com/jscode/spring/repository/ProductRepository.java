package com.jscode.spring.repository;

import com.jscode.spring.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository {

    private final static List<Product> store = new ArrayList<>();


    public Long save(Product product) {
        store.add(product);
        return product.getId();
    }


    public Product findOne(String name) {
        for (Product product : store) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }


    public List<Product> findAll() {
        return new ArrayList<>(store);
    }
}
