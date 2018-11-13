package com.example.scdf.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(SimpleTaskProperties.class)
public class SimpleTaskCommandLineRunner implements CommandLineRunner {

    @Autowired
    private SimpleTaskProperties simpleTaskProperties;

    @Override
    public void run(String... args) throws Exception {
        log.info("************************");
        log.info("payload value!!!!");
        log.info(simpleTaskProperties.getPayload());
//        System.getenv().forEach((k, v) -> log.info("\t{}:\t{}", k, v));
        log.info("************************");
        Thread.sleep(5000);
    }
}
