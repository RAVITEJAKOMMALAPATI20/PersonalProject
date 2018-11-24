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
		
		entityManager.persist(movie);
		entityManager.flush();
		
		
		return movie;
	}
	
	public void deleteMovieDAO(Movie movie) {
		entityManager.remove(movie);
		
	}
	public Movie updatMovieDAO(Movie movie) {
		
		
		Movie resmovie =entityManager.merge(movie);
		entityManager.flush();
		return resmovie;
	}
	
	public List<Movie> getAllMoviesDAO() {
		
		List<Movie> listMovies =null;
		try {
		TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.getAllMovies",Movie.class);
		listMovies = query.getResultList();
		}catch(Exception ex) {
			throw new MovieCentralRepositoryException(ex.getMessage());
		}
		return listMovies;
	}

}
