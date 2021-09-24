package com.scent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BackendApplication.class);
		app.addListeners(new ApplicationPidFileWriter()); 
		app.run(args);
	}
}
