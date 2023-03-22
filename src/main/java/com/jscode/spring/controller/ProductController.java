package com.jscode.spring.controller;

import com.jscode.spring.dto.ProductDto;
import com.jscode.spring.dto.ProductEntityDto;
import com.jscode.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;


    /**
     * ProductJpaRepository 사용
     */
    @GetMapping
    public ProductEntityDto findOneById(@RequestParam Long id){
        return productService.findById(id);
    }

    @PostMapping
    public Long save(@RequestBody ProductEntityDto productEntityDto){
        return productService.save(productEntityDto);
    }

    /**
     * ProductRepository 사용
     */
//    @PostMapping
//    public String addProduct(@RequestBody ProductDto productDto) {
//        try {
//            Long productId = productService.save(productDto);
//            return String.valueOf(productId);
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }

//    @GetMapping
//    public String getProduct(@RequestParam String name, @RequestParam String monetaryUnit) {
//        try {
//            if (monetaryUnit.equals("won")) {
//                return productService.findOne(name).toStringToWon();
//            } else return productService.findOne(name).toStringToDollar();
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }

}

