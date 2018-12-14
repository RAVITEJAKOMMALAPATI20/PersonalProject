/**
 * 
 */
package com.moviecentral.utils;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author ravitejakommalapati
 *
 */

@Component
public class MovieCentralMailingUtil {
	
	
	//@Autowired
    //private IUserService service;
  
   // @Autowired
   // private MessageSource messages;
  
    @Autowired
    private JavaMailSender mailSender;
 
   public void confirmRegistration(String toEmailAddress) {
	   
	   String token = UUID.randomUUID().toString();
	   String subject = "Movie Central Registration Confirmation";
	   SimpleMailMessage email = new SimpleMailMessage(); 
	   email.setTo(toEmailAddress); 
	   email.setSubject(subject); 
	  
       email.setText(  " rn" + "Please Click the following link for Confirmation--"+"http://ec2-35-166-105-174.us-west-2.compute.amazonaws.com:8080"+token);
       mailSender.send(email);
	   
   }
	
	

}
