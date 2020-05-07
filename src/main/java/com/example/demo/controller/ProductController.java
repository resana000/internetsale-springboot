package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.domain.ProductCategory;
import com.example.demo.dto.MessageResponse;
import com.example.demo.exception.DBFindException;
import com.example.demo.exception.NonSaved;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/add/{name}")
    public ResponseEntity add(@PathVariable String name,
                              @RequestBody Product product){
        productService.add(product);
        return ResponseEntity.ok(new MessageResponse());

    }

    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @Transactional
    @PostMapping("/update/{id}")
    public void update(@PathVariable Long id,
                                 @RequestBody Product consumeProduct){
        productService.add(consumeProduct);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(productService.getById(id));
    }
}
