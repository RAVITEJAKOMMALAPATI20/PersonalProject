/**
 * 
 */
package com.moviecentral.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecentral.dao.SubscriptionDAO;
import com.moviecentral.pojos.UserSubscription;

/**
 * @author ravitejakommalapati
 *
 */

@Service
public class SubscriptionService {
	
	@Autowired
	private SubscriptionDAO subscriptionDAO;
	
	public UserSubscription saveSubscriptionService(UserSubscription subscription) {
		subscriptionDAO.saveSubscriptionDao(subscription);
		return subscription;
	}
	
	public UserSubscription updateSubscriptionService(UserSubscription subscription) {
		subscriptionDAO.updateSubscriptionDao(subscription);
		return subscription;
	}

	public void deleteSubscriptionService(UserSubscription subscription) {
		subscriptionDAO.deleteSubscriptionDao(subscription);
		
	}
	
	public List<UserSubscription> getAllSubscriptionsService(String username) {
		List<UserSubscription> userSubscriptionList=subscriptionDAO.getAllSubscriptionsDao(username);
		return userSubscriptionList;
	}

}
