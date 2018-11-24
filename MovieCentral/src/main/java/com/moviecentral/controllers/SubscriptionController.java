/**
 * 
 */
package com.moviecentral.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import com.moviecentral.pojos.UserSubscription;
import com.moviecentral.services.SubscriptionService;

/**
 * @author ravitejakommalapati
 *
 */
@RestController
@RequestMapping("/users")
public class SubscriptionController {

	@Autowired SubscriptionService subscriptionService;
	
	@PostMapping("/savesubscription")
	public UserSubscription saveSubscription(@RequestBody UserSubscription subscription,WebRequest request) {
		System.out.println(subscription.getUsername());
		subscription.setStartdate(null);
		UserSubscription resUserSubscription=subscriptionService.saveSubscriptionService(subscription);
		return resUserSubscription;
		
	}
	
	
	@PostMapping("/updatesubscription")
	public UserSubscription updateSubscription(@RequestBody UserSubscription subscription,WebRequest request) {
		UserSubscription ressubscription = subscriptionService.updateSubscriptionService(subscription);
		return ressubscription;
	}

	@PostMapping("/deletesubscription")
	public UserSubscription deleteSubscription(@RequestBody UserSubscription subscription,WebRequest request) {

		UserSubscription resUserSubscription=subscriptionService.deleteSubscriptionService(subscription);
		return resUserSubscription;
	}
	
	@GetMapping("/getallsubscriptions")
	public List<UserSubscription> getAllSubscriptions(String username) {
		List<UserSubscription>  reslistUserSubscription =subscriptionService.getAllSubscriptionsService(username);
		return reslistUserSubscription;
	}
}
