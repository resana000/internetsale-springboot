package com.example.demo.service;

import com.example.demo.TestContainer;
import com.example.demo.TestKafkaContainer;
import com.example.demo.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productService;

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = TestContainer.getInstance();

    @ClassRule
    public static KafkaContainer kafka = TestKafkaContainer.getInstance();

    @Before
    public void before() {
        Product product = new Product();
        product.setName("Name");
        product.setId(1L);
        productService.add(product);
    }

    @Test
    @Order(2)
    public void getById() {
        Product product = productService.getById(1L);
        assertEquals(productService.getById(1L).getName(), "Name");

    }
}