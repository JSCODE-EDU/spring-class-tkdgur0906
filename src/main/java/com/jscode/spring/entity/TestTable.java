package com.jscode.spring.entity;

import javax.persistence.*;

@Entity
@Table
public class TestTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public TestTable() {
    }
}
