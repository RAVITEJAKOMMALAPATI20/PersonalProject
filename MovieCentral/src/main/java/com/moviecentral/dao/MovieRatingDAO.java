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
import com.moviecentral.pojos.MovieRating;
import com.moviecentral.pojos.Payment;

/**
 * @author ravitejakommalapati
 *
 */
@Repository
@Transactional
@Component
public class MovieRatingDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Movie saveratingDao(MovieRating movieRating,Movie movie) {
		
		prepareMovieRating(movieRating);
		
		Movie resmovie=entityManager.find(Movie.class, movieRating.getMovieid());
		resmovie.setRating(movieRating.getRating()+"");
		
		entityManager.persist(movieRating);
		entityManager.persist(resmovie);
		return resmovie;
	}
	
	
	public List<Movie> getTopTenMoviesDao() {
		List<Movie> listMovies =null;
		try {
		TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.getTopTenMoviesDao",Movie.class);
		listMovies = query.getResultList();
		}catch(Exception ex) {
			throw new MovieCentralRepositoryException(ex.getMessage());
		}
		return listMovies;
	}
	
	private void prepareMovieRating(MovieRating movieRating) {
		double newRating =0.0;
		MovieRating resMovieRating=entityManager.find(MovieRating.class, movieRating.getMovieid());
		newRating=(resMovieRating.getRating()+movieRating.getRating())/resMovieRating.getUsersrated()+1;
		
		movieRating.setUsersrated(resMovieRating.getUsersrated()+1);
		movieRating.setRating(newRating);
		movieRating.setLastupdateddate(movieRating.getLastupdateddate());
	}
}
