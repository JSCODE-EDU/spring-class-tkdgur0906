package com.jscode.spring.Product;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public String addProduct(@RequestBody ProductDto productDto) {
        try {
            Long productId = productService.save(productDto);
            return String.valueOf(productId);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping
    public String getProduct(@RequestParam String name, @RequestParam String monetaryUnit) {
        try {
            if (monetaryUnit.equals("won")) {
                return productService.findOne(name).toStringToWon();
            } else return productService.findOne(name).toStringToDollar();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

