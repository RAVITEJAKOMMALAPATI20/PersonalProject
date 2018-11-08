/**
 * 
 */
package com.moviecentral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.moviecentral.pojos.Movie;

/**
 * @author ravitejakommalapati
 *
 */
@Repository
@Transactional
@Component
public class MovieDAO {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	

	public Movie saveMovieDAO(Movie movie) {
		
		
		return null;
	}
	
	public void deleteMovieDAO(Movie movie) {
		
		
	}
	public Movie updatMovieDAO(Movie movie) {
		
		
		return null;
	}
	
	public List<Movie> getAllMoviesDAO(Movie movie) {
		
		
		return null;
	}

}
