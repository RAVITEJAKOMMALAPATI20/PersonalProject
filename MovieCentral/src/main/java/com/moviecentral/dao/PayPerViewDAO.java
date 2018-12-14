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

import com.moviecentral.pojos.PayPerview;

/**
 * @author ravitejakommalapati
 *
 */

@Repository
@Transactional
@Component
public class PayPerViewDAO  {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public PayPerview savePayPerviewDao(PayPerview payPerview) {
		entityManager.persist(payPerview);
		return payPerview;
	}
	public PayPerview checkUserDao(PayPerview payPerview) {
		List<PayPerview> listpayPerview =null;
		PayPerview respayPerview =null;
		TypedQuery<PayPerview> query = entityManager.createNamedQuery("PayPerview.checkUser",PayPerview.class);
		query.setParameter("user", payPerview.getUser());
		query.setParameter("movie", payPerview.getMovie());
		query.setMaxResults(1);
		listpayPerview =query.getResultList();
		if(listpayPerview!=null&&listpayPerview.size()>0) {
			respayPerview = listpayPerview.get(0);
		}
		
		return respayPerview;
	}
	
	public List<PayPerview> getpayperviewsDao(PayPerview payPerview) {
		
		List<PayPerview> listpayPerview =null;
		PayPerview respayPerview =null;
		TypedQuery<PayPerview> query = entityManager.createNamedQuery("PayPerview.usermovies",PayPerview.class);
		query.setParameter("user", payPerview.getUser());
		
		listpayPerview =query.getResultList();
		if(listpayPerview!=null&&listpayPerview.size()>0) {
			respayPerview = listpayPerview.get(0);
		}
		
		return listpayPerview;
	}
}
