/**
 * 
 */
package com.moviecentral.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.moviecentral.event.OnRegistrationSuccessEvent;
import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.exceptions.MovieCentralValidationException;
import com.moviecentral.pojos.Payment;
import com.moviecentral.pojos.User;
import com.moviecentral.services.PaymentService;

/**
 * @author ravitejakommalapati
 *
 */
@RequestMapping("/users")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping("/savepayment")
	public Payment savepaymentdetails(@RequestBody Payment payment,WebRequest request) {
		Payment respayment = paymentService.savepaymentdetailsService(payment);
		return respayment;
	}
	@PostMapping("/updatepayment")
	public Payment updatepaymentdetails(@RequestBody Payment payment,WebRequest request) {
		Payment respayment =paymentService.updatepaymentdetailsService(payment);
		return respayment;
	}
	@PostMapping("/deletepayment")
	public void deletepaymentdetails(@RequestBody Payment payment,WebRequest request) {
		paymentService.deletepaymentdetailsService(payment);
	}
	@GetMapping("/getpayments")
	public List<Payment> getAllpaymentdetails(@RequestParam("username") String username,WebRequest request) {
		List<Payment> respaymentsList=paymentService.getAllpaymentdetailsService(username);
		return respaymentsList;
	}

}
