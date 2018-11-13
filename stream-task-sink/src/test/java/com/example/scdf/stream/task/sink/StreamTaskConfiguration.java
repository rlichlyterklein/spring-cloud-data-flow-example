package com.example.scdf.stream.task.sink;

import org.springframework.cloud.deployer.spi.task.TaskLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class StreamTaskConfiguration {

    @Bean
    public TaskLauncher taskLauncher() {
        return mock(TaskLauncher.class);
    }

}
