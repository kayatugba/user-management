package com.tugbakaya.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.tugbakaya.userrepository.entity","com.tugbakaya.userrepository.repository"})
@ComponentScan({"com.tugbakaya.*"})
@EntityScan("com.tugbakaya.userrepository.entity")
@EnableJpaRepositories("com.tugbakaya.userrepository.repository")
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
