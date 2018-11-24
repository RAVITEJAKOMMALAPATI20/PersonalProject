/**
 * 
 */
package com.moviecentral.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.pojos.VerificationToken;

/**
 * @author ravitejakommalapati
 *
 */
@Repository
@Transactional
@Component
public class TokenDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void createVerificationTokenDao(VerificationToken token) throws MovieCentralRepositoryException {
		System.out.println(token.getId());
		System.out.println(token.getExpiryDate());
		System.out.println(token.getToken());
		System.out.println(token.getCreatedDate());
		try {
		entityManager.persist(token);
		}catch(Exception exception) {
			throw new MovieCentralRepositoryException("Saving the token to the database");
		}
		
	}
	
	public VerificationToken findByToken(String token) {
		Query query = entityManager.createNamedQuery("VerificationToken.findByToken");
		query.setParameter("token", token);

		VerificationToken userToken = null;
		try {
			 userToken = (VerificationToken)query.getSingleResult();
		} catch (Exception e) {
			userToken = null;
			e.printStackTrace();
		}
		return userToken;
		
	}
}
