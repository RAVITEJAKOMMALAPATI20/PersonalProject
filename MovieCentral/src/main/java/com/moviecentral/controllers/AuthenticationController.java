/**
 * 
 */
package com.moviecentral.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ravitejakommalapati
 *
 */
@RestController
public class AuthenticationController {
	
	
	@RequestMapping("/user/login")
    public void userLogin() {
        
    }
	
	@RequestMapping("/user/SignUp")
    public void userSignUp() {
        
    }
	@RequestMapping("/user/Activation")
    public void userActivation() {
        
    }

}
