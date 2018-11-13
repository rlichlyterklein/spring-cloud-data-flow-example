package com.example.scdf.dataflowserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.dataflow.shell.EnableDataFlowShell;

@EnableDataFlowShell
@SpringBootApplication
public class DataflowShellApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataflowShellApplication.class, args);
	}
}
