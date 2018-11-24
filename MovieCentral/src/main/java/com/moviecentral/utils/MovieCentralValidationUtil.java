/**
 * 
 */
package com.moviecentral.utils;

import org.springframework.stereotype.Component;

import com.moviecentral.exceptions.MovieCentralValidationException;
import com.moviecentral.pojos.UserSubscription;

/**
 * @author ravitejakommalapati
 *
 */
@Component
public class MovieCentralValidationUtil {
	
	
	
	public void validateUserSubscription(UserSubscription subscription)  {
		if(subscription==null||subscription.getUsername()==null||
				subscription.getUsername()==""||
				subscription.getStartdate()==null||
				subscription.getEnddate()==null||
				subscription.getSubscriptionid()==0) {
			throw new MovieCentralValidationException("User Subscription details provided are not valid");
		}
		
	}

}
