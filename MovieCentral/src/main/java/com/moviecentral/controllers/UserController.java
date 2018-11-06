/**
 * 
 */
package com.moviecentral.controllers;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.moviecentral.event.OnRegistrationSuccessEvent;
import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.exceptions.MovieCentralValidationException;
import com.moviecentral.pojos.User;
import com.moviecentral.pojos.VerificationToken;
import com.moviecentral.services.UserService;
import com.moviecentral.utils.MovieCentralUtil;

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
	
	
	
	@PostMapping("/signin")
	public void userSignin(@RequestBody User user,WebRequest request) {

	System.out.println(user.getEmail());
	try {
		User registered_user=userService.signinUserService(user);
	    String appUrl = request.getContextPath();
	    Locale locale=request.getLocale();
	    eventPublisher.publishEvent(new OnRegistrationSuccessEvent(registered_user,locale,appUrl));
	} catch (MovieCentralRepositoryException | MovieCentralValidationException e) {
		e.printStackTrace();
		
	}catch (Exception e) {
       e.printStackTrace();
    }
		
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
