/**
 * 
 */
package com.moviecentral.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.pojos.MovieRating;
import com.moviecentral.pojos.MovieRatingResponse;

/**
 * @author ravitejakommalapati
 *
 */
@Repository
@Transactional
@Component
public class MovieRatingDAO  {

	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	public MovieRating saveratingDao(MovieRating movieRating) {
		List<MovieRating> listMovieRating =null;
		TypedQuery<MovieRating> query = entityManager.createNamedQuery("MovieRating.getSingleRating",MovieRating.class);
		query.setParameter("user", movieRating.getUser());
		query.setParameter("movie", movieRating.getMovie());
		listMovieRating = query.getResultList();
		if(listMovieRating==null||listMovieRating.size()==0) {
			System.out.println("Here");
		entityManager.persist(movieRating);
		}else {
			System.out.println("Here2");
			entityManager.merge(movieRating);
		}
		return movieRating;
	}
	
	
	public MovieRating getratingDao(MovieRating movieRating) {
		System.out.println(movieRating.getUser().getUsername());
		System.out.println(movieRating.getMovie().getMovieid());
		MovieRating resMovieRating =null;
		List<MovieRating> listMovieRating =null;
		TypedQuery<MovieRating> query = entityManager.createNamedQuery("MovieRating.getSingleRating",MovieRating.class);
		query.setParameter("user", movieRating.getUser());
		query.setParameter("movie", movieRating.getMovie());
		listMovieRating = query.getResultList();
		if(listMovieRating==null||listMovieRating.size()==0) {
			return resMovieRating;
		}else {
			System.out.println("Here2+getratingDao");
			return resMovieRating =listMovieRating.get(0);
		}
		
	}
	
	
	public List<MovieRating> getallcommentDao(MovieRating movieRating) {
		MovieRating resMovieRating =null;
		List<MovieRating> listMovieRating =null;
		TypedQuery<MovieRating> query = entityManager.createNamedQuery("MovieRating.getallcomments",MovieRating.class);
		query.setParameter("movie", movieRating.getMovie());
		query.setMaxResults(20);
		listMovieRating = query.getResultList();
		return listMovieRating;
	}
	
	
	public List<Object> getTopTenMoviesDao() {
		//List<MovieRatingResponse> resMovieRatingResponse =new ArrayList<MovieRatingResponse>();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -30);
		Date dateBefore30Days = cal.getTime();
		System.out.println(dateBefore30Days+"");
		List<Object> listMovies =null;
		try {
		Query query = entityManager.createNamedQuery("MovieRating.getTopTenMovies");
		query.setParameter("enddate",new Date());
		query.setParameter("startdate", dateBefore30Days);
		query.setMaxResults(10);
		listMovies = query.getResultList();
		}catch(Exception ex) {
			throw new MovieCentralRepositoryException(ex.getMessage());
		}
		return listMovies;
	}
	
	
}
