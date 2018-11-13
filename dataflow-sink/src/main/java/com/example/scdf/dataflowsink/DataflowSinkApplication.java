package com.example.scdf.dataflowsink;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
@Slf4j
public class DataflowSinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataflowSinkApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void loggerSink(String date) {
       log.info(date);
    }

}
