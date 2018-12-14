/**
 * 
 */
package com.moviecentral.event;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
    public JavaMailSender emailSender;

	@Override
	public void onApplicationEvent(OnRegistrationSuccessEvent event) {
		try {
			this.confirmRegistration(event);
		} catch (MovieCentralRepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void confirmRegistration(OnRegistrationSuccessEvent event)   {
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		String toEmailAddress = user.getEmail();
        String confirmationUrl = event.getAppUrl() + "/users/confirmRegistration?token=" + token; 
        System.out.println("confirmationUrl=="+confirmationUrl);
 	    String subject = "Movie Central Registration Confirmation";
 	    
 	/*   MimeMessage message = emailSender.createMimeMessage();
 	   try {
		message.setContent("<html><body><div>Hi</div></body></html>","text/html");
		   MimeMessageHelper helper = new MimeMessageHelper(message, true);
	 	    helper.setTo(toEmailAddress);
	 	    helper.setSubject(subject);
	 	    helper.setText(confirmationUrl); 
 	   } catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
 	   }
       
 	
 	    emailSender.send(message); */
		userService.createVerificationTokenService(user,token);
		
 	    SimpleMailMessage email = new SimpleMailMessage(); 
 	    email.setTo(toEmailAddress); 
 	    email.setSubject(subject); 
        email.setText( "Please click the Link to activate your account\n"+"http://ec2-35-166-105-174.us-west-2.compute.amazonaws.com:8080"+confirmationUrl);
        mailSender.send(email);
		
	}
	
	
}