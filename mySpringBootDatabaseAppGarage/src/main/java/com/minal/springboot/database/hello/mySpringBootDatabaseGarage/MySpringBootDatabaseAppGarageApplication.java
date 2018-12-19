package com.minal.springboot.database.hello.mySpringBootDatabaseGarage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MySpringBootDatabaseAppGarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootDatabaseAppGarageApplication.class, args);
	}
}
