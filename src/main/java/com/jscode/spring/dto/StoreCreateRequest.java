package com.jscode.spring.dto;

import com.jscode.spring.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreCreateRequest {

    private String name;

    private Address address;

    private String phoneNumber;

}
