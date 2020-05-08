package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;

@Slf4j
public class TestKafkaContainer extends KafkaContainer {
    private static final String IMAGE_VERSION = "5.0.3";
    private static TestKafkaContainer container;
    static boolean iniUser = false;

    private TestKafkaContainer() {
        super(IMAGE_VERSION);
    }

    @Test
    public static TestKafkaContainer getInstance() {
        if (container == null) {
            container = new TestKafkaContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        log.info("start {} {}", container.getBootstrapServers(), container.getExposedPorts());
        System.setProperty("kafka-serv", container.getBootstrapServers());
        System.setProperty("kafka-topic", "topic0");
        System.setProperty("kafka-group-id", container.getContainerId());

    }



    @Override
    public void stop() {
    }
}
