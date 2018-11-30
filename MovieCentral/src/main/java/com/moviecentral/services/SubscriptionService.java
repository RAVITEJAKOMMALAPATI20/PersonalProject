/**
 * 
 */
package com.moviecentral.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecentral.dao.SubscriptionDAO;
import com.moviecentral.exceptions.MovieCentralValidationException;
import com.moviecentral.pojos.UserSubscription;
import com.moviecentral.utils.MovieCentralUtil;
import com.moviecentral.utils.MovieCentralValidationUtil;

/**
 * @author ravitejakommalapati
 *
 */

@Service
public class SubscriptionService {
	
	@Autowired
	private SubscriptionDAO subscriptionDAO;
	@Autowired
	MovieCentralUtil movieCentralUtil;
	@Autowired
	MovieCentralValidationUtil movieCentralValidationUtil;
	
	public UserSubscription saveSubscriptionService(UserSubscription subscription) {
		Date date=movieCentralUtil.calculateSupsriptionEnddate(subscription.getDuration());
		subscription.setEnddate(date);
		subscription.setSubscriptionstatus(true);
		movieCentralValidationUtil.validateUserSubscription(subscription);
		
		
		UserSubscription resUserSubscription=subscriptionDAO.saveSubscriptionDao(subscription);
		return resUserSubscription;
		
		
	}
	
	public UserSubscription updateSubscriptionService(UserSubscription subscription) {
		UserSubscription resUserSubscription= subscriptionDAO.updateSubscriptionDao(subscription);
		return resUserSubscription;
	}

	public UserSubscription dropSubscriptionService(UserSubscription subscription) {
		subscription.setDropsubscription(true);
		subscription.setAutoreneval(false);
		UserSubscription resUserSubscription=subscriptionDAO.dropSubscriptionDao(subscription);
		return resUserSubscription;
		
	}
	
	public List<UserSubscription> getAllSubscriptionsService(String username) {
		List<UserSubscription> userSubscriptionList=subscriptionDAO.getAllSubscriptionsDao(username);
		return userSubscriptionList;
	}
	
	

}
