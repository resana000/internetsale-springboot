package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    Product getById(Long id);
    List<Product> getProducts(ProductCriteria productCriteria);
    void add (Product product);
    void add (List<Product> productList);
    void update (List<Product> product);
    void delete (Product product);


}
