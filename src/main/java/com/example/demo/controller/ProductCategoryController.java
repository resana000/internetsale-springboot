package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.domain.ProductCategory;
import com.example.demo.exception.DBFindException;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @PostMapping("/add-all")
    public ResponseEntity add(@RequestBody List<ProductCategory> productCategoryList){
       productCategoryRepository.saveAll(productCategoryList);
        return ResponseEntity.ok(Collections.singletonMap("result", "добавлено"));
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable Long id){
        return ResponseEntity.
                ok(productCategoryRepository.findById(id));
    }
}
