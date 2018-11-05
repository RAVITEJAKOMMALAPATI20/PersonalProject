/**
 * 
 */
package com.moviecentral.event;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.pojos.User;
import com.moviecentral.services.UserService;

/**
 * @author ravitejakommalapati
 *
 */
@Component
public class RegistrationEmailListener implements ApplicationListener<OnRegistrationSuccessEvent> {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messages;
	
	@Autowired
	private MailSender mailSender;

	@Override
	public void onApplicationEvent(OnRegistrationSuccessEvent event) {
		try {
			this.confirmRegistration(event);
		} catch (MovieCentralRepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void confirmRegistration(OnRegistrationSuccessEvent event) throws MovieCentralRepositoryException {
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		String toEmailAddress = user.getEmail();
        String confirmationUrl = event.getAppUrl() + "/users/confirmRegistration?token=" + token; 
        System.out.println("confirmationUrl=="+confirmationUrl);
 	    String subject = "Movie Central Registration Confirmation";
 	    
 	    
		userService.createVerificationTokenService(user,token);
		
		
 	    SimpleMailMessage email = new SimpleMailMessage(); 
 	    email.setTo(toEmailAddress); 
 	    email.setSubject(subject); 
        email.setText( "http://localhost:8080"+confirmationUrl);
        mailSender.send(email);
		
	}
	
	
}