package com.api.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner fetchStudent(RestConsumer restConsumer) {
		return args -> {
			log.info("----------------------- GET -------------------------");
			log.info("GETTING STUDENT BY ID");
			log.info("Student:  " + restConsumer.getStudentById(1L));
		};
	}

	@Bean
	public CommandLineRunner putStudent(RestConsumer restConsumer) {
		return args -> {
			log.info("----------------------- PUT -------------------------");
			Student before = restConsumer.getStudentById(1L);
			log.info("BEFORE:  " + before);
			restConsumer.updateStudent(new Student(1L, "Test", "Test", "Test"));
			Student after = restConsumer.getStudentById(1L);
			log.info("AFTER:  " + after);
		};
	}

	@Bean
	public CommandLineRunner deleteStudent(RestConsumer restConsumer) {
		return args -> {
			log.info("---------------------- DELETE ------------------------");
			restConsumer.deleteStudent(2L);
		};
	}

	// Add a student
	@Bean
	public CommandLineRunner addStudent(RestConsumer restConsumer) {
		return args -> {
			log.info("----------------------- POST -------------------------");
			restConsumer.createStudent(new Student("Test", "Test", "Test"));
		};
	}

}
