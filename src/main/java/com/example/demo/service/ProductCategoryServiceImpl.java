package com.example.demo.service;

import com.example.demo.domain.ProductCategory;
import com.example.demo.exception.DBFindException;
import com.example.demo.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory getById(Long id) {
        return productCategoryRepository.findById(id).orElseThrow(
                () -> new DBFindException(String.format("Product Category=%d not found", id)));
    }

    @Override
    public void addAll(List<ProductCategory> list) {
        productCategoryRepository.saveAll(list);
    }
}
