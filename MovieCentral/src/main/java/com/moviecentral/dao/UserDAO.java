/**
 * 
 */
package com.moviecentral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.pojos.Movie;
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
	
	public User signinUserDao(User user) {
		
		try {
		 entityManager.persist(user);
		entityManager.flush();
		
		}catch(Exception ex) {
			throw new MovieCentralRepositoryException(ex.getMessage());
		}
		return user;
	}
	
	public User loginUserDao(User user) {
		System.out.println(user.getUsername());
		User regestered =null;
		try {
			regestered=entityManager.find(User.class, user.getUsername());
		    //entityManager.flush();
		
		}catch(Exception ex) {
			throw new MovieCentralRepositoryException(ex.getMessage());
		}
		return regestered;
	}
	
	public void save(User user) {
		
		entityManager.merge(user);
	}
public List<User> getAllUsersDao() {
	List<User> listUsers =null;
	try {
	TypedQuery<User> query = entityManager.createNamedQuery("User.getAllUsers",User.class);
	listUsers = query.getResultList();
	}catch(Exception ex) {
		throw new MovieCentralRepositoryException(ex.getMessage());
	}
		
		return listUsers;
	}
	
public User updateuserDao(User user) {
	
	
     	entityManager.merge(user);
     	entityManager.flush();

		return user;
	}

}
