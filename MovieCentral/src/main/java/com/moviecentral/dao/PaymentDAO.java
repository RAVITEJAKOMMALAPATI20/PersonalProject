/**
 * 
 */
package com.moviecentral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.moviecentral.pojos.Payment;

/**
 * @author ravitejakommalapati
 *
 */
@Repository
@Transactional
@Component
public class PaymentDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Payment savepaymentdetailsDao(Payment payment) {

		entityManager.persist(payment);
		
		return payment;
	}
	
	public Payment updatepaymentdetailsDao(Payment payment) {

		
		entityManager.merge(payment);
		
		return payment;
	}

	public void deletepaymentdetailsDao(Payment payment) {

		entityManager.remove(payment);
	}
	
	public List<Payment> getAllpaymentdetailsDao( String username) {
		Query query = entityManager.createNamedQuery("Payment.getAllpaymentdetails");
		query.setParameter("username", username);
		
		
		return null;
	}

}
