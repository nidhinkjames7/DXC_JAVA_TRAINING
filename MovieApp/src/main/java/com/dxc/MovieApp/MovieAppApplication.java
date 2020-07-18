package com.dxc.MovieApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MovieAppApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MovieAppApplication.class, args);
	}

}
