package com.moviecentral;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moviecentral.pojos.User;
import com.moviecentral.services.UserService;

@SpringBootApplication
public class MovieCentralApplication {
	//@Autowired
	//private static UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(MovieCentralApplication.class, args);
		UserService userService =new UserService();
		System.out.println(userService+"kkkkkkkkkkk");
		User user = new User();
		user.setEmail("1ra4vi3");
		user.setPassword("password");
		user.setUserName("rsajdhdbjh");
		userService.saveUserService(user);
	}
}
