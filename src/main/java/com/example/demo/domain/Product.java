package com.example.demo.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String article;

    Double price;

    @CreationTimestamp
    LocalDateTime creationTime;

    @UpdateTimestamp
    LocalDateTime updateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    ProductCategory productCategory;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Warehouse warehouse;
}
