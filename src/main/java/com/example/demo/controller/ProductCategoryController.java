package com.example.demo.controller;

import com.example.demo.domain.ProductCategory;
import com.example.demo.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-category")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PostMapping("/add-all")

    public void add(@RequestBody List<ProductCategory> productCategoryList) {
        productCategoryService.addAll(productCategoryList);
    }

    @GetMapping("{id}")
    public ProductCategory getById(@PathVariable Long id) {
        return productCategoryService.getById(id);
    }
}
