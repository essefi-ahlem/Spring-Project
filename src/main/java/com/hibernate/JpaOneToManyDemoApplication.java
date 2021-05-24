package com.hibernate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.hibernate.repository")
public class JpaOneToManyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyDemoApplication.class, args);
	}

}