/**
 * 
 */
package com.moviecentral.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecentral.dao.PaymentDAO;
import com.moviecentral.pojos.Payment;

/**
 * @author ravitejakommalapati
 *
 */
@Service
public class PaymentService {

	@Autowired
	private PaymentDAO paymentDao;
	public Payment savepaymentdetailsService(Payment payment) {
		paymentDao.savepaymentdetailsDao(payment);
		return payment;
	}
	
	public Payment updatepaymentdetailsService(Payment payment) {
		paymentDao.updatepaymentdetailsDao(payment);
		return payment;
	}

	public void deletepaymentdetailsService(Payment payment) {

		paymentDao.deletepaymentdetailsDao(payment);
	}
	
	public List<Payment> getAllpaymentdetailsService(String username) {
		List<Payment> paymentsList=paymentDao.getAllpaymentdetailsDao(username);
		return paymentsList;
	}

}
