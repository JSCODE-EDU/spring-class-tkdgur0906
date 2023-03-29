package com.jscode.spring.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String road;

    private String detail;

    protected Address() {
    }
}
