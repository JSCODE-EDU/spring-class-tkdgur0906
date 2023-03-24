package com.jscode.spring.repository;


import com.jscode.spring.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    public List<ProductEntity> findAllBy();

    public ProductEntity findByName(String name);

    public List<ProductEntity> findAllByName(String name);

    public List<ProductEntity> findAllByPriceOrderByNameDesc(Long price);

    public List<ProductEntity> findAllByNameAndPrice(String name, Long price);

    public List<ProductEntity> findAllByNameLike(String name);

    public ProductEntity findTopByOrderByPriceDesc();

    public List<ProductEntity> findAllByNameContaining(String name);

    @Query("select p.name from ProductEntity p where p.price = (select min(p2.price) from ProductEntity p2)")
    public String findNameOfCheapestProduct();

    @Query("select avg(p.price) from ProductEntity p")
    public double findAvgPrice();
}
