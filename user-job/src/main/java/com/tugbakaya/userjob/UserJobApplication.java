package com.tugbakaya.userjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@EntityScan("com.tugbakaya.userrepository.entity")
@EnableJpaRepositories("com.tugbakaya.userrepository.repository")
@SpringBootApplication
@EnableScheduling
public class UserJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserJobApplication.class, args);
	}

}
