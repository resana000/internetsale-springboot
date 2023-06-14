package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    private static String TOPIC = "products";

    @KafkaListener(topics = "topic0", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info(String.format("consume message = %s", message));
    }
}
