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
import com.moviecentral.pojos.UserSubscription;

/**
 * @author ravitejakommalapati
 *
 */

@Repository
@Transactional
@Component
public class SubscriptionDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public UserSubscription saveSubscriptionDao(UserSubscription subscription) {
	
		entityManager.persist(subscription);
		return subscription;
		
	}
	
	public UserSubscription updateSubscriptionDao(UserSubscription subscription) {
		UserSubscription resUserSubscription=entityManager.merge(subscription);
		return resUserSubscription;
	}

	public UserSubscription dropSubscriptionDao(UserSubscription subscription) {
		UserSubscription resUserSubscription=entityManager.merge(subscription);
		return resUserSubscription;
	}
	
	public List<UserSubscription> getAllSubscriptionsDao(String username) {
		Query query = entityManager.createNamedQuery("UserSubscription.getAllsubscriptions");
		query.setParameter("username", username);
		List<UserSubscription> reslistUserSubscription = query.getResultList();
		return reslistUserSubscription;
	}

}
