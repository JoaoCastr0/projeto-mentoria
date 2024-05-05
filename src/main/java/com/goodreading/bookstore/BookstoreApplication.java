package com.goodreading.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/cda");
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
