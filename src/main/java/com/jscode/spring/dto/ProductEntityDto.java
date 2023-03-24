package com.jscode.spring.dto;

import com.jscode.spring.domain.ProductEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductEntityDto {

    private Long id;

    private String name;

    private Long price;

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .id(id)
                .name(name)
                .price(price)
                .build();
    }

    @Builder
    public ProductEntityDto(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
