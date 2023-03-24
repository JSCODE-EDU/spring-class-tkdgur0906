package com.jscode.spring.repository;

import com.jscode.spring.domain.ProductEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProductJpaRepositoryTest {

    @Autowired
    ProductJpaRepository productJpaRepository;


    @Test
    void findAllByNameLike() {
        //given
        List<ProductEntity> products = productJpaRepository.findAllByNameLike("모니터");

        //when
        //then
        assertThat(products.isEmpty()).isTrue();
    }

    @Test
    void findTopByOrderByPriceDesc() {
        //given
        ProductEntity product = productJpaRepository.findTopByOrderByPriceDesc();

        //when
        //then
        assertThat(product.getPrice()).isEqualTo(170000L);
    }

    @Test
    void findAllByNameContaining() {
        //given
        List<ProductEntity> products = productJpaRepository.findAllByNameContaining("컴");

        //when
        //then
        assertThat(products.size()).isEqualTo(2);
    }

    @Test
    void findNameOfCheapestProduct() {
        //given
        String name = productJpaRepository.findNameOfCheapestProduct();

        //when
        //then
        assertThat(name).isEqualTo("싸요");
    }

    @Test
    void findAvgPrice() {
        //given
        double avgPrice = productJpaRepository.findAvgPrice();

        List<ProductEntity> products = productJpaRepository.findAllBy();
        double expectAvg = 0;
        for (ProductEntity product : products) {
            expectAvg += product.getPrice();
        }
        expectAvg = expectAvg / products.size();

        //when
        //then
        assertThat(avgPrice).isEqualTo(expectAvg);

    }
}