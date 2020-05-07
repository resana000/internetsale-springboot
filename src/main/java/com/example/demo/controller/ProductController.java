package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.domain.ProductCategory;
import com.example.demo.exception.DBFindException;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/add/{name}")
    public ResponseEntity add(@PathVariable String name){
        Product product = new Product();
        product.setArticle("wadwd");
        product.setName(name);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("qdwdqwd");
        product.setProductCategory(productCategory);
        return ResponseEntity.ok(productRepository.save(product));

    }

    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productRepository.findById(id));
    }

    @Transactional
    @PostMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Product consumeProduct){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new DBFindException(String.format("Продукт id %s не найден", id))
        );
        product.setName(consumeProduct.getName());
        return ResponseEntity.ok(product);
    }
}
