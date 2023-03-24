package com.jscode.spring.domain;

import com.jscode.spring.dto.ProductEntityDto;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    protected ProductEntity() {
    }

    public ProductEntityDto toDto() {
        return ProductEntityDto.builder()
                .id(id)
                .name(name)
                .price(price)
                .build();

    }

    @Builder
    public ProductEntity(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
