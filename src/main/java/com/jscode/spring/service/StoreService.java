package com.jscode.spring.service;

import com.jscode.spring.domain.ProductEntity;
import com.jscode.spring.domain.Store;
import com.jscode.spring.dto.StoreCreateRequest;
import com.jscode.spring.dto.ProductIdDto;
import com.jscode.spring.dto.StoreInfoResponse;
import com.jscode.spring.repository.ProductJpaRepository;
import com.jscode.spring.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService {

    private final ProductJpaRepository productRepository;
    private final StoreRepository storeRepository;

    public Long save(StoreCreateRequest request) {
        Store store = Store.createStore(request.getName(), request.getAddress(), request.getPhoneNumber());
        Store save = storeRepository.save(store);
        return store.getId();
    }

    public StoreInfoResponse findOne(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        return new StoreInfoResponse(store.get());
    }

    public void addProduct(Long storeId, ProductIdDto product) {
        Optional<Store> store = storeRepository.findById(storeId);
        Optional<ProductEntity> findProduct = productRepository.findById(product.getId());
        store.get().addProduct(findProduct.get());
    }

    public List<StoreInfoResponse> findOrders() {
        List<Store> orders = storeRepository.findAll();
        return orders.stream()
                .map(o -> new StoreInfoResponse(o))
                .collect(Collectors.toList());
    }
}
