package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;

@Slf4j
public class TestContainer extends PostgreSQLContainer<TestContainer> {
    private static final String IMAGE_VERSION = "postgres:11.1";
    private static TestContainer container;
    static boolean iniUser = false;

    private TestContainer() {
        super(IMAGE_VERSION);
    }

    @Test
    public static TestContainer getInstance() {
        if (container == null) {
            container = new TestContainer()
                    .withDatabaseName("integration-testsdb")
                    .withUsername("sa")
                    .withPassword("sa");
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        log.info("started {} {}", container.getJdbcUrl(), container.getExposedPorts());
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());

    }



    @Override
    public void stop() {
    }
}
