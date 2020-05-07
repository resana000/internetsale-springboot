package com.example.demo.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

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
