package com.cyriljoui.spring.poc.graylog;

import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info(">> Starting");
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);
        logger.info("<< Started");


        int index = 0;
        while (true) {
            logger.info("Graylog POC INFO, index: {}", index++);

            if (index % 30 == 0) {
                logger.error("Simulate error @index: {}", index);
            }

            Thread.sleep(500);
        }

    }
}
