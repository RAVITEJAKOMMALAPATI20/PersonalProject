/**
 * 
 */
package com.moviecentral.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ravitejakommalapati
 *
 */


@RestController
@RequestMapping("/users")
public class SocialLoginController {
	
	
	@RequestMapping("/googleLogin")
	public Principal googleLogin(Principal principal){
		
		
		
		return principal;
	}

}
