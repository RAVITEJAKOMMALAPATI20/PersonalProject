/**
 * 
 */
package com.moviecentral.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping("/savepayment")
	public Payment savepaymentdetails(@RequestBody Payment payment,WebRequest request)  {
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
