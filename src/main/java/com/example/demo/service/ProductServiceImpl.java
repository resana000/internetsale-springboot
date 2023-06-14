package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.exception.DBFindException;
import com.example.demo.exception.NonSaved;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new DBFindException(String.format("product=%d not found", id)));
    }

    @Override
    public List<Product> getProducts(ProductCriteria productCriteria) {
        return null;
    }

    @Transactional
    @Override
    public void add(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if (optionalProduct.isPresent())
            throw new NonSaved(String.format("product id=%d already exist", product.getId()));

        productRepository.save(product);
    }

    @Override
    public void add(List<Product> productList) throws NonSaved {
        productRepository.saveAll(productList);
    }

    @Override
    public void update(List<Product> product) {

    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
