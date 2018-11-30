package com.moviecentral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;




@SpringBootApplication
public class MovieCentralApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(MovieCentralApplication.class, args);
		
	}
	
}
