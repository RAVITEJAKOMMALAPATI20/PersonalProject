/**
 * 
 */
package com.moviecentral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.moviecentral.exceptions.MovieCentralRepositoryException;
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
	try {
					entityManager.persist(payment);
		}catch(Exception ex) {
			System.out.println("hiii");
				throw new MovieCentralRepositoryException(ex.getMessage());
		}
		
		return payment;
	}
	
	public Payment updatepaymentdetailsDao(Payment payment) {
	try {
		entityManager.merge(payment);
	}catch(Exception ex) {
		throw new MovieCentralRepositoryException(ex.getMessage());
	}
		return payment;
	}

	public void deletepaymentdetailsDao(Payment payment) {
try {
			payment =entityManager.find(Payment.class,payment);
		entityManager.remove(payment);
	}catch(Exception ex) {
		ex.getStackTrace();
		throw new MovieCentralRepositoryException(ex.getMessage());
	}
	}
	
	public List<Payment> getAllpaymentdetailsDao( String username) {
		List<Payment> listPayments =null;
		try {
		TypedQuery<Payment> query = entityManager.createNamedQuery("Payment.getAllpaymentdetails",Payment.class);
		query.setParameter("username", username);
		listPayments = query.getResultList();
		}catch(Exception ex) {
			throw new MovieCentralRepositoryException(ex.getMessage());
		}
		return listPayments;
	}

}
