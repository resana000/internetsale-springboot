package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.domain.ProductCategory;
import com.example.demo.dto.MessageResponse;
import com.example.demo.exception.DBFindException;
import com.example.demo.exception.NonSaved;
import com.example.demo.kafka.KafkaProducer;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.google.common.base.Strings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@Api("Продукты")
public class ProductController {

    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    ProductService productService;

    @GetMapping("/test")
    public String test(){
        kafkaProducer.sendMessage("test");
        return "test";
    }

    @ApiOperation("Добавить товар")
    @PostMapping("/add/{name}")
    public ResponseEntity add(@ApiParam("Название") @PathVariable String name,
                              @RequestBody Product product){
        productService.add(product);
        return ResponseEntity.ok(new MessageResponse());

    }


    @ApiOperation("Получить по id")
    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @ApiOperation("Обновить")
    @Transactional
    @PostMapping("/update/{id}")
    public void update(@PathVariable Long id,
                                 @RequestBody Product consumeProduct){
        productService.add(consumeProduct);
    }

    @ApiOperation("Удалить")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(productService.getById(id));
    }


    @PostMapping("upload-image/{id}")
    public ResponseEntity uploadImage(@PathVariable Long id,
                            @RequestParam("file") MultipartFile multipartFile) throws IOException {
        String name = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        Path path = Paths.get(name);
        Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        return ResponseEntity.ok(name);


    }
}
