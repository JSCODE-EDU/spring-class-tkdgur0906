package com.jscode.spring.controller;

import com.jscode.spring.dto.*;
import com.jscode.spring.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public StoreCreateResponse storeAdd(@RequestBody StoreCreateRequest request) {
        Long id = storeService.save(request);
        return new StoreCreateResponse(id);
    }

    @PostMapping("/{id}")
    public Long productAdd(@PathVariable Long id, @RequestBody ProductIdDto product) {
        storeService.addProduct(id, product);
        StoreInfoResponse findStore = storeService.findOne(id);
        return findStore.getId();
    }

    @GetMapping
    public Result<StoreInfoResponse> storeList() {
        return new Result(storeService.findOrders());
    }

    @GetMapping(params = "id")
    public StoreInfoResponse storeGet(@RequestParam Long id) {
        return storeService.findOne(id);
    }


}
