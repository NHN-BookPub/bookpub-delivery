package com.nhnacademy.bookpubdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BookpubDeliveryApplication {


	public static void main(String[] args) {
		SpringApplication.run(BookpubDeliveryApplication.class, args);
	}

}
