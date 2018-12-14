/**
 * 
 */
package com.moviecentral.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.moviecentral.dao.PayPerViewDAO;
import com.moviecentral.pojos.PayPerview;
import com.moviecentral.services.PayPerViewService;

/**
 * @author ravitejakommalapati
 *
 */

@RestController
@RequestMapping("/payperview")
public class PayPerViewController {
	
	@Autowired
	PayPerViewService payPerViewService;
	
	
	@PostMapping("/savepayperview")
	public PayPerview savePayPerviewController(@RequestBody PayPerview payPerview,WebRequest request) {
		PayPerview respayPerview =payPerViewService.savePayPerviewServce(payPerview);
	return respayPerview;
	
	}
	
	
	@GetMapping("/checkpayperview")
	public PayPerview checkUserConroller(@RequestParam("payperview") PayPerview payPerview,WebRequest request) {
		PayPerview respayPerview = payPerViewService.checkUserService(payPerview);
		return respayPerview;
	}
	@GetMapping("/getpayperviews")
	public List<PayPerview> getpayperviews(@RequestParam("payperview") String username,WebRequest request) {
		List<PayPerview> respayPerview = payPerViewService.getpayperviewsService(username);
		return respayPerview;
	}

}
