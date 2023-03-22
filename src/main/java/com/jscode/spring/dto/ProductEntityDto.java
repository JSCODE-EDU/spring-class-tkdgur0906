package com.jscode.spring.dto;

import com.jscode.spring.domain.ProductEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductEntityDto {

    private String name;

    private Long price;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .name(name)
                .price(price)
                .build();
    }

    @Builder
    public ProductEntityDto(String name, Long price){
        this.name = name;
        this.price = price;
    }
}
