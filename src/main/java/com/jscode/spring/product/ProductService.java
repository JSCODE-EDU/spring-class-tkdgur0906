package com.jscode.spring.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private static Long sequence = 0L;


    public Long save(ProductDto productDto) {
        Product newProduct = new Product(sequence++, productDto.getName(), productDto.getPrice());
        validateSameName(newProduct);
        return productRepository.save(newProduct);
    }


    public Product findOne(String name) {
        Product findProduct = productRepository.findOne(name);
        validateExistName(findProduct);
        return findProduct;
    }


    private void validateSameName(Product newProduct) {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            if (newProduct.getName().equals(product.getName())) {
                throw new IllegalArgumentException("동일한 이름의 상품이 존재합니다.");
            }
        }
    }

    private static void validateExistName(Product findProduct) {
        if (findProduct == null) {
            throw new NullPointerException("존재하지 않는 상품명입니다.");
        }
    }

}
