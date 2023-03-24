package com.jscode.spring.domain;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DynamicInsert
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @Column(name = "class")
    @ColumnDefault("'basic'")
    private String studentClass;


    public Student() {
    }
}
