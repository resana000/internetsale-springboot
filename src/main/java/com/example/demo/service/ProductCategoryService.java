package com.example.demo.service;

import com.example.demo.domain.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory getById(Long id);
    void addAll (List<ProductCategory> productCategoryList);
}
