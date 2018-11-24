/**
 * 
 */
package com.moviecentral.controllers;

import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviecentral.event.OnRegistrationSuccessEvent;
import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.exceptions.MovieCentralValidationException;
import com.moviecentral.pojos.User;
import com.moviecentral.pojos.VerificationToken;
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
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	
	
	@PostMapping("/signup")
	public User userSignup(@RequestBody User user,WebRequest request) {
	
	
		User registered_user=userService.signinUserService(user);
		
	    String appUrl = request.getContextPath();
	    Locale locale=request.getLocale();
	    eventPublisher.publishEvent(new OnRegistrationSuccessEvent(registered_user,locale,appUrl));
	    request.setAttribute("user", registered_user, WebRequest.SCOPE_SESSION);
	    return registered_user;
		
	}	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/signin")
	public User userSignin(@RequestBody User user,WebRequest request) {
	
		User registered_user=userService.loginUserService(user);
	    //request.setAttribute("user", registered_user, WebRequest.SCOPE_SESSION);

	   
	    return registered_user;
		
	}
	
	@GetMapping("/confirmRegistration")
	public String confirmRegistration(WebRequest request, Model model,@RequestParam("token") String token) {
		System.out.println("In side confirmRegistration UserController");
		Locale locale=request.getLocale();
		VerificationToken verificationToken = userService.getVerificationToken(token);
		if(verificationToken == null) {
			//String message = messages.getMessage("auth.message.invalidToken", null, locale);
			//model.addAttribute("message", message);
			return "redirect:access-denied";
		}
		User user = verificationToken.getUser();
		Calendar calendar = Calendar.getInstance();
		if((verificationToken.getExpiryDate().getTime()-calendar.getTime().getTime())<=0) {
			//String message = messages.getMessage("auth.message.expired", null, locale);
			//model.addAttribute("message", message);
			return "redirect:access-denied";
		}
		
		user.setEnable(true);
		userService.enableRegisteredUser(user);
		return "You have been activated";
	}
}
