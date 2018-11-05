/**
 * 
 */
package com.moviecentral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.exceptions.MovieCentralValidationException;
import com.moviecentral.pojos.User;
import com.moviecentral.services.UserService;

/**
 * @author ravitejakommalapati
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@PostMapping("/signin")
	public void userSignin(@RequestBody User user) {
	System.out.println(user.getEmail());
	try {
		userService.signinUserService(user);
	} catch (MovieCentralRepositoryException | MovieCentralValidationException e) {
		
	}
		
	}

	
	
	
}
