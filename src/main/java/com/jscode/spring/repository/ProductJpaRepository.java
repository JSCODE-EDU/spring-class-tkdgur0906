package com.jscode.spring.repository;


import com.jscode.spring.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    public ProductEntity findByName(String name);

    public List<ProductEntity> findAllByName(String name);
}
