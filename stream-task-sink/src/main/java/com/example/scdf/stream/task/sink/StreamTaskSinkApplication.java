package com.example.scdf.stream.task.sink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

/**
 * A task sink application for launching tasks
 *
 * @author Rich Lichlyter-Klein
 */
@SpringBootApplication
@EnableTaskLauncher
public class StreamTaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamTaskSinkApplication.class, args);
	}
}
