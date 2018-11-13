package com.example.scdf.dataflowprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@EnableBinding(Processor.class)
@Slf4j
@SpringBootApplication
public class DataflowProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataflowProcessorApplication.class, args);
	}


	@StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object transform(Long timestamp) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:yy");
        String date = dateFormat.format(timestamp);
        log.info("Processor transform v2 {}", date);
        return date;
    }
}
