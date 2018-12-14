/**
 * 
 */
package com.moviecentral.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moviecentral.dao.PayPerViewDAO;
import com.moviecentral.pojos.PayPerview;
import com.moviecentral.pojos.User;

/**
 * @author ravitejakommalapati
 *
 */
@Service
public class PayPerViewService {
	
	@Autowired
	PayPerViewDAO payPerViewDAO;
	
	public PayPerview savePayPerviewServce(PayPerview payPerview) {
	payPerview.setPaymentdate(new Date());
	
	PayPerview resPayPerview  =  payPerViewDAO.savePayPerviewDao(payPerview);
	
	return resPayPerview;
		
	}
	
	public PayPerview checkUserService(PayPerview payPerview) {
		PayPerview resPayPerview = payPerViewDAO.checkUserDao(payPerview);
		return resPayPerview;
	
	}
	
	public List<PayPerview> getpayperviewsService(String username) {
		User user =new User();
		user.setUsername(username);
		PayPerview payPerview =new PayPerview();
		payPerview.setUser(user);
		List<PayPerview> resPayPerview = payPerViewDAO.getpayperviewsDao(payPerview);
		return resPayPerview;
	
	}
}
