package com.jscode.spring.dto;

import com.jscode.spring.domain.Address;
import com.jscode.spring.domain.Store;
import lombok.Data;

import javax.persistence.Embedded;

@Data
public class StoreInfoResponse {

    private Long id;

    private String name;

    @Embedded
    private Address address;

    private String phoneNumber;


    public StoreInfoResponse(Store store) {
        id = store.getId();
        name = store.getName();
        address = store.getAddress();
        phoneNumber = store.getPhoneNumber();
    }
}
