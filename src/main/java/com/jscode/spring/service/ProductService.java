package com.jscode.spring.service;

import com.jscode.spring.domain.Product;
import com.jscode.spring.domain.ProductEntity;
import com.jscode.spring.dto.ProductDto;
import com.jscode.spring.dto.ProductEntityDto;
import com.jscode.spring.repository.ProductJpaRepository;
import com.jscode.spring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductJpaRepository productJpaRepository;
    private static Long sequence = 0L;

    /**
     * ProductJpaRepository
     */

    public ProductEntityDto save(ProductEntityDto productEntityDto){
        return productJpaRepository.save(productEntityDto.toEntity()).toDto();
    }

    public ProductEntityDto findById(Long id){
        return productJpaRepository.findById(id).get().toDto();
    }

    /**
     * ProductRepository
     */
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
