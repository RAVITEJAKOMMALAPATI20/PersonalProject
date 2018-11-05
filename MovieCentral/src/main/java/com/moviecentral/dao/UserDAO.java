/**
 * 
 */
package com.moviecentral.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.moviecentral.pojos.User;

/**
 * @author ravitejakommalapati
 *
 */
//@Transactional is used to open a transaction and close a transaction
//all the DB operations is called is one transaction instead of opening and closing every where whe defined for total class
@Repository
@Transactional
@Component
public class UserDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveUserDao(User user) {
		
		entityManager.persist(user);
		
	}
	
	

}
