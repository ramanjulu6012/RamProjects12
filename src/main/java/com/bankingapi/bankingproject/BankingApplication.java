package com.bankingapi.bankingproject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class BankingApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
		System.out.println("Spring Application Started.....");
	}


}
