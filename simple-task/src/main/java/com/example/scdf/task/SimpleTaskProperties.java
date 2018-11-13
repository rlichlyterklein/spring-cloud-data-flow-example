package com.example.scdf.task;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Data
public class SimpleTaskProperties {

    /**
     * Retreives the payload value set by TaskLauncher
     */
    private String payload;

}
