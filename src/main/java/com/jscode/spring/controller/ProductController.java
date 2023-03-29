package com.jscode.spring.controller;

import com.jscode.spring.dto.ProductEntityDto;
import com.jscode.spring.dto.Result;
import com.jscode.spring.dto.StoreInfoResponse;
import com.jscode.spring.exception.custom.NoParamException;
import com.jscode.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;


    /**
     * ProductJpaRepository 사용
     */
    @GetMapping(params = "id")
    public ProductEntityDto findById(@RequestParam Long id) {
        return productService.findById(id);
    }

    @GetMapping(params = "name")
    public ProductEntityDto findByName(@RequestParam String name) {
        return productService.findByName(name);
    }

    @GetMapping(params = "price")
    public List<ProductEntityDto> findAllByPrice(@RequestParam Long price) {
        return productService.findAllByPrice(price);
    }

    @GetMapping(params = {"name", "price"})
    public List<ProductEntityDto> findAllByNameAndPrice(@RequestParam String name,
                                                        @RequestParam Long price) {
        return productService.findAllByNameAndPrice(name, price);
    }


    @PostMapping
    public Long save(@RequestBody ProductEntityDto productEntityDto) {
        return productService.save(productEntityDto);
    }

    @GetMapping(params = "store")
    public Result<StoreInfoResponse> productsInStoreGet(@RequestParam("store") Long storeId) {
        return new Result(productService.findProductsInStore(storeId));
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

