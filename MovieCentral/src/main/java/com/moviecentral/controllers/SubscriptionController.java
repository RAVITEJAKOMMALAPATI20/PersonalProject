/**
 * 
 */
package com.moviecentral.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.moviecentral.pojos.Payment;
import com.moviecentral.pojos.UserSubscription;

/**
 * @author ravitejakommalapati
 *
 */

@RequestMapping("/users")
public class SubscriptionController {

	
	@PostMapping("/savesubscription")
	public UserSubscription saveSubscription(@RequestBody UserSubscription subscription,WebRequest request) {

		return null;
	}
	
	
	@PostMapping("/updatesubscription")
	public UserSubscription updateSubscription(@RequestBody UserSubscription subscription,WebRequest request) {

		return null;
	}

	@PostMapping("/deletesubscription")
	public void deleteSubscription(@RequestBody UserSubscription subscription,WebRequest request) {

		
	}
	
	@GetMapping("/getallsubscriptions")
	public List<UserSubscription> getAllSubscriptions(String username) {

		return null;
	}
}
